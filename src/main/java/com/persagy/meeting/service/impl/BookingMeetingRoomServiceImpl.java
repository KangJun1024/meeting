package com.persagy.meeting.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.persagy.meeting.common.util.DateUtil;
import com.persagy.meeting.common.util.StringUtil;
import com.persagy.meeting.common.util.ToolsUtil;
import com.persagy.meeting.entity.BookingMeetingRoom;
import com.persagy.meeting.entity.BookingMeetingRoomExample;
import com.persagy.meeting.mapper.BookingMeetingRoomMapper;
import com.persagy.meeting.service.BaseService;
import com.persagy.meeting.service.BookingMeetingRoomService;
import com.persagy.meeting.timer.MessageJob;
import com.persagy.meeting.timer.StateJob;
import org.apache.commons.lang.time.DateUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Service("bookingMeetingRoomService")
public class BookingMeetingRoomServiceImpl implements BookingMeetingRoomService {

    private static final Logger log = LoggerFactory.getLogger(StateJob.class);

    @Autowired
    private BookingMeetingRoomMapper bookingMeetingRoomMapper;
    @Autowired
    private BaseService baseService;
    @Autowired
    @Qualifier("quartzScheduler")
    Scheduler quartzScheduler;

    //获取CorpAccessToken URL
    private String corpAccessTokenURL = "https://open.fxiaoke.com/cgi/corpAccessToken/get/V2";
    //消息
    private String messageURL = "https://open.fxiaoke.com/cgi/message/send";
    private String corpAccessToken = null;
    private String corpId = null;

    @Override
    public String bookingOrUpdateMeeting(JSONObject jsonObject) throws Exception {
        //获取会议参数
        String booking_person_id = jsonObject.getString("booking_person_id");
        String booking_person_name = jsonObject.getString("booking_person_name");
        String booking_person_picture = jsonObject.getString("booking_person_picture");
        String meeting_start_time = jsonObject.getString("meeting_start_time");
        String meeting_end_time = jsonObject.getString("meeting_end_time");
        String room_id = jsonObject.getString("room_id");
        String room_name = jsonObject.getString("room_name");
        String topic = jsonObject.getString("topic");
        String booking_room_id = jsonObject.getString("booking_room_id");
        JSONArray participants = jsonObject.getJSONArray("participants");
        JSONArray meeting_reminders = jsonObject.getJSONArray("meeting_reminders");
        //验证修改 or 添加
        if (booking_room_id == null || "".equals(booking_room_id)) {
            String bookingRoomId = StringUtil.getDesignatedUUID("BM");
            BookingMeetingRoom bookingMeetingRoom = new BookingMeetingRoom();
            bookingMeetingRoom.setBookiongRoomId(bookingRoomId);
            bookingMeetingRoom.setBookingPersonId(booking_person_id);
            bookingMeetingRoom.setBookingPersonName(booking_person_name);
            bookingMeetingRoom.setBookingPersonPicture(booking_person_picture);
            bookingMeetingRoom.setMeetingStartTime(meeting_start_time);
            bookingMeetingRoom.setMeetingEndTime(meeting_end_time);
            bookingMeetingRoom.setRoomId(room_id);
            bookingMeetingRoom.setRoomName(room_name);
            bookingMeetingRoom.setTopic(topic);
            bookingMeetingRoom.setValid(true);
            bookingMeetingRoom.setStatus("0"); //0:已预约;1:已开始;2:已结束;3:已取消
            bookingMeetingRoom.setCreateTime(DateUtil.getNowTimeStr());
            bookingMeetingRoom.setUpdateTime(DateUtil.getNowTimeStr());
            bookingMeetingRoom.setParticipants(participants.toJSONString());
            bookingMeetingRoom.setMeetingReminders(meeting_reminders.toJSONString());

            int insert = bookingMeetingRoomMapper.insert(bookingMeetingRoom);
            if(insert > 0){
                //添加任务
                //会议室已开始、已结束状态的变化
//                addStateTask(bookingMeetingRoom);
                //消息的提醒方式
//                addMessageTask(bookingMeetingRoom);
                return ToolsUtil.successJsonMsg(bookingRoomId) ;
            }else {
                return ToolsUtil.errorJsonMsg("会议室预约失败");
            }
        }else{
            //会议变更
            BookingMeetingRoom bookingMeetingRoom = new BookingMeetingRoom();
            bookingMeetingRoom.setBookingPersonId(booking_person_id);
            bookingMeetingRoom.setBookingPersonName(booking_person_name);
            bookingMeetingRoom.setBookingPersonPicture(booking_person_picture);
            bookingMeetingRoom.setMeetingStartTime(meeting_start_time);
            bookingMeetingRoom.setMeetingEndTime(meeting_end_time);
            bookingMeetingRoom.setRoomId(room_id);
            bookingMeetingRoom.setRoomName(room_name);
            bookingMeetingRoom.setTopic(topic);
            bookingMeetingRoom.setValid(true);
            bookingMeetingRoom.setStatus("0"); //0:已预约;1:已开始;2:已结束;3:已取消
            bookingMeetingRoom.setUpdateTime(DateUtil.getNowTimeStr());
            bookingMeetingRoom.setParticipants(participants.toJSONString());
            bookingMeetingRoom.setMeetingReminders(meeting_reminders.toJSONString());
            BookingMeetingRoomExample bookingMeetingRoomExample = new BookingMeetingRoomExample();
            BookingMeetingRoomExample.Criteria criteria = bookingMeetingRoomExample.createCriteria();
            criteria.andBookingPersonIdEqualTo(booking_room_id);

            int i = bookingMeetingRoomMapper.updateByExampleSelective(bookingMeetingRoom, bookingMeetingRoomExample);
            if(i > 0){
                //TODO  message 通知参会人变更会议  会议开始状态的定时任务(修改之后)
                //1. 删除消息状态定时任务
//                deleteMessageJob(booking_room_id);
//                deleteStateJob(booking_room_id);
                //添加任务
                //会议室已开始、已结束状态的变化
//                bookingMeetingRoom.setBookiongRoomId(booking_room_id);
//                addStateTask(bookingMeetingRoom);
                //消息的提醒方式
//                addMessageTask(bookingMeetingRoom);

                return ToolsUtil.successJsonMsg(room_id) ;
            }else {
                return ToolsUtil.errorJsonMsg("修改会议室失败");
            }
        }
    }

    private void addMessageTask(BookingMeetingRoom bookingMeetingRoom) throws Exception{
        //获取会议参数
        String booking_room_id = bookingMeetingRoom.getBookiongRoomId();
        //参会人
        String participants = bookingMeetingRoom.getParticipants();
        //会议开始时间
        String meeting_start_time = bookingMeetingRoom.getMeetingStartTime();
        LocalDateTime localDateTime = DateUtil.parse(meeting_start_time);
        //会议提醒时间  //0:准时提醒;1:提前15min;2:提前1h;3:提前2小时
        String meetingReminders = bookingMeetingRoom.getMeetingReminders();
        JobDetail jobDetail = JobBuilder.newJob(MessageJob.class).withIdentity(booking_room_id, "message").usingJobData("booking_room_id",booking_room_id).
                usingJobData("participants",participants).build();
        HashSet<Trigger> triggerSet = new HashSet<Trigger>();
        if (meetingReminders != null) {
            JSONArray jsonArray = JSONArray.parseArray(meetingReminders);
            for (Object o : jsonArray) {
                String reminder = (String) o;
                Date time = getReminderTime(localDateTime,reminder);
                log.info("任务时间为:[{}]，定时任务为:[{}]",time,booking_room_id);
                Trigger trigger = TriggerBuilder.newTrigger().startAt(time)
                        .withIdentity("trigger_"+booking_room_id+"_"+ reminder, booking_room_id)
                        .withSchedule(simpleSchedule().withMisfireHandlingInstructionIgnoreMisfires()).build();
                triggerSet.add(trigger);
            }
        }
        quartzScheduler.scheduleJob(jobDetail, triggerSet,true);
    }

    private Date getReminderTime(LocalDateTime localDateTime, String reminder) {
        Date date = DateUtil.localDateTime2Date(localDateTime);
        if("1".equals(reminder)){
           return DateUtils.addMinutes(date,-15);
        }else if("2".equals(reminder)){
            return DateUtils.addHours(date,-1);
        }else if("3".equals(reminder)){
            return DateUtils.addHours(date,-2);
        }
        return date;
    }

    private void addStateTask(BookingMeetingRoom bookingMeetingRoom) throws Exception{
        //获取会议参数
        String booking_room_id = bookingMeetingRoom.getBookiongRoomId();
        //会议开始时间
        String meeting_start_time = bookingMeetingRoom.getMeetingStartTime();
        //会议结束时间
        String meeting_end_time = bookingMeetingRoom.getMeetingEndTime();
        LocalDateTime meetingStateTime = DateUtil.parse(meeting_start_time);
        LocalDateTime meetingEndTime = DateUtil.parse(meeting_end_time);
        JobDetail jobDetail = JobBuilder.newJob(StateJob.class).withIdentity(booking_room_id, "state").usingJobData("booking_room_id",booking_room_id).build();
        log.info("任务时间为:[{}]，定时任务为:[{}]",DateUtil.format(meetingStateTime),booking_room_id);
        Trigger triggerStart = TriggerBuilder.newTrigger().startAt(DateUtil.localDateTime2Date(meetingStateTime))
                .withIdentity("trigger_"+booking_room_id+"_"+ "start", booking_room_id)
                .withSchedule(simpleSchedule().withMisfireHandlingInstructionIgnoreMisfires()).usingJobData("type","1").build();
        Trigger triggerEnd = TriggerBuilder.newTrigger().startAt(DateUtil.localDateTime2Date(meetingEndTime))
                .withIdentity("trigger_"+booking_room_id+"_"+ "end", booking_room_id)
                .withSchedule(simpleSchedule().withMisfireHandlingInstructionIgnoreMisfires()).usingJobData("type","2").build();
        HashSet<Trigger> triggerSet = new HashSet<Trigger>();
        triggerSet.add(triggerStart);
        triggerSet.add(triggerEnd);
        quartzScheduler.scheduleJob(jobDetail, triggerSet,true);

    }

    @Override
    public String cancelOrDeleteMeeting(JSONObject jsonObject) throws Exception {
        //获取会议参数
        String booking_room_id = jsonObject.getString("booking_room_id");
        String message = jsonObject.getString("message"); //取消说明
        String status = jsonObject.getString("status"); //2:已结束;3:已取消;已删除
        if("2".equals(status)){
            //结束
            BookingMeetingRoom bookingMeetingRoom = new BookingMeetingRoom();
            bookingMeetingRoom.setStatus(status);
            BookingMeetingRoomExample bookingMeetingRoomExample = new BookingMeetingRoomExample();
            BookingMeetingRoomExample.Criteria criteria = bookingMeetingRoomExample.createCriteria();
            criteria.andBookingPersonIdEqualTo(booking_room_id);

            int i = bookingMeetingRoomMapper.updateByExampleSelective(bookingMeetingRoom, bookingMeetingRoomExample);
            if(i > 0){
                return ToolsUtil.successJsonMsg("success") ;
            }else {
                return ToolsUtil.errorJsonMsg("修改会议失败");
            }

        }else if("3".equals(status)){
            //取消    TODO发消息
            BookingMeetingRoom bookingMeetingRoom = new BookingMeetingRoom();
            bookingMeetingRoom.setStatus(status);
            BookingMeetingRoomExample bookingMeetingRoomExample = new BookingMeetingRoomExample();
            BookingMeetingRoomExample.Criteria criteria = bookingMeetingRoomExample.createCriteria();
            criteria.andBookingPersonIdEqualTo(booking_room_id);

            int i = bookingMeetingRoomMapper.updateByExampleSelective(bookingMeetingRoom, bookingMeetingRoomExample);
            if(i > 0){
                //0. 会议取消通知
//                BookingMeetingRoom bookingMeetingRoom1 = queryMeetingDetail(booking_room_id);
//                String participants = bookingMeetingRoom1.getParticipants();
//                JSONArray users = getUserIds(participants);
//                JSONObject jsonObj = new JSONObject();
//                jsonObj.put("users",users);
//                jsonObj.put("text",message); //TODO
//                sendMessage(jsonObj);
//                //1. 删除消息状态定时任务
//                deleteMessageJob(booking_room_id);
//                deleteStateJob(booking_room_id);
                return ToolsUtil.successJsonMsg("success") ;
            }else {
                return ToolsUtil.errorJsonMsg("取消会议失败");
            }
        }else {
            //删除 valid为false
            BookingMeetingRoom bookingMeetingRoom = new BookingMeetingRoom();
            bookingMeetingRoom.setStatus(status);
            bookingMeetingRoom.setValid(false);
            BookingMeetingRoomExample bookingMeetingRoomExample = new BookingMeetingRoomExample();
            BookingMeetingRoomExample.Criteria criteria = bookingMeetingRoomExample.createCriteria();
            criteria.andBookingPersonIdEqualTo(booking_room_id);

            int i = bookingMeetingRoomMapper.updateByExampleSelective(bookingMeetingRoom, bookingMeetingRoomExample);
            if(i > 0){
                return ToolsUtil.successJsonMsg("success") ;
            }else {
                return ToolsUtil.errorJsonMsg("修改会议失败");
            }
        }
    }

    private void deleteMessageJob(String booking_room_id) throws Exception{
        JobKey jobKey = new JobKey(booking_room_id, "message");
        boolean checkExists = quartzScheduler.checkExists(jobKey);
        if (checkExists) {
            quartzScheduler.deleteJob(new JobKey(booking_room_id, "message"));
        }
    }

    private void deleteStateJob(String booking_room_id) throws Exception{
        JobKey jobKey = new JobKey(booking_room_id, "state");
        boolean checkExists = quartzScheduler.checkExists(jobKey);
        if (checkExists) {
            quartzScheduler.deleteJob(new JobKey(booking_room_id, "state"));
        }
    }

    /**
     * 获得参会人列表
     * @param participants
     * @return
     */
    private JSONArray getUserIds(String participants) {
        JSONArray ids = new JSONArray();
        if (participants != null) {
            JSONArray users = JSONArray.parseArray(participants);
            for (Object user : users) {
                JSONObject u = (JSONObject) user;
                ids.add(u.getString("person_id"));
            }
        }
        return ids;
    }

    @Override
    public String queryMyCreatedMeeting(JSONObject jsonObject) throws Exception {
        //获取会议参数
        String user_name = jsonObject.getString("user_name");
        //封装参数
        BookingMeetingRoomExample bookingMeetingRoomExample = new BookingMeetingRoomExample();
        BookingMeetingRoomExample.Criteria criteria = bookingMeetingRoomExample.createCriteria();
        criteria.andBookingPersonNameEqualTo(user_name);
        criteria.andValidEqualTo(true);
        List<BookingMeetingRoom> bookingMeetingRooms = bookingMeetingRoomMapper.selectByExample(bookingMeetingRoomExample);
        //会议名称、状态、会议室名称、时间
        JSONArray jsonArray = new JSONArray();
        if (bookingMeetingRooms != null && bookingMeetingRooms.size() > 0) {
            for (BookingMeetingRoom bookingMeetingRoom : bookingMeetingRooms) {
                JSONObject object = new JSONObject();
                object.put("booking_room_id",bookingMeetingRoom.getBookiongRoomId());
                object.put("status",bookingMeetingRoom.getStatus());
                object.put("room_name",bookingMeetingRoom.getRoomName());
                object.put("meeting_start_time",bookingMeetingRoom.getMeetingStartTime());
                object.put("meeting_end_time",bookingMeetingRoom.getMeetingEndTime());
                jsonArray.add(object);
            }
        }
        return ToolsUtil.successJsonMsg(jsonArray);
    }

    @Override
    public String queryMyParticipantMeeting(JSONObject jsonObject) throws Exception {
        //获取会议参数
        String user_name = jsonObject.getString("user_name");
        //封装参数
        BookingMeetingRoomExample bookingMeetingRoomExample = new BookingMeetingRoomExample();
        BookingMeetingRoomExample.Criteria criteria = bookingMeetingRoomExample.createCriteria();
        criteria.andValidEqualTo(true);
        List<BookingMeetingRoom> bookingMeetingRooms = bookingMeetingRoomMapper.selectByExample(bookingMeetingRoomExample);
        //会议名称、状态、会议室名称、时间、组织者姓名
        JSONArray jsonArray = new JSONArray();
        if (bookingMeetingRooms != null && bookingMeetingRooms.size() > 0) {
            for (BookingMeetingRoom bookingMeetingRoom : bookingMeetingRooms) {
                if(!bookingMeetingRoom.getParticipants().contains(user_name)){
                    continue;
                }
                JSONObject object = new JSONObject();
                object.put("booking_room_id",bookingMeetingRoom.getBookiongRoomId());
                object.put("status",bookingMeetingRoom.getStatus());
                object.put("room_name",bookingMeetingRoom.getRoomName());
                object.put("meeting_start_time",bookingMeetingRoom.getMeetingStartTime());
                object.put("meeting_end_time",bookingMeetingRoom.getMeetingEndTime());
                object.put("booking_person_name",bookingMeetingRoom.getBookingPersonName());
                jsonArray.add(object);
            }
        }
        return ToolsUtil.successJsonMsg(jsonArray);
    }

    @Override
    public String startMeeting(JSONObject jsonObject) throws Exception {
        //获取会议参数
        String booking_room_id = jsonObject.getString("booking_room_id");
        String state = jsonObject.getString("state");
        //结束  valid为false
        BookingMeetingRoom bookingMeetingRoom = new BookingMeetingRoom();
        bookingMeetingRoom.setStatus(state);
        BookingMeetingRoomExample bookingMeetingRoomExample = new BookingMeetingRoomExample();
        BookingMeetingRoomExample.Criteria criteria = bookingMeetingRoomExample.createCriteria();
        criteria.andBookingPersonIdEqualTo(booking_room_id);

        int i = bookingMeetingRoomMapper.updateByExampleSelective(bookingMeetingRoom, bookingMeetingRoomExample);
        if(i > 0){
            return ToolsUtil.successJsonMsg("success") ;
        }else {
            return ToolsUtil.errorJsonMsg("开始会议失败");
        }
    }

    @Override
    public String sendMessage(JSONObject jsonObject) throws Exception {
        getSignature();
        Map<String,Object> obj = new HashMap<String, Object>();
        obj.put("corpAccessToken",corpAccessToken);
        obj.put("corpId",corpId);
        //消息内容
        JSONObject text = jsonObject.getJSONObject("text");
        //发送人
        JSONArray users = jsonObject.getJSONArray("users");

        obj.put("toUser",users);
        obj.put("msgType","composite");
        obj.put("composite",text);

        String result = baseService.httpPostRequest(messageURL, obj);
        return result;
    }

    @Override
    public BookingMeetingRoom queryMeetingDetail(String booking_room_id) throws Exception {
        BookingMeetingRoom bookingMeetingRoom = bookingMeetingRoomMapper.selectByPrimaryKey(booking_room_id);

        return bookingMeetingRoom;
    }

    //获取数字签名
    public void getSignature() throws Exception{
        //appId
        String appId = "FSAID_131860e";
        //appSecret
        String appSecret = "e1c53d3c6dff4e96b9ec155a031889af";
        //永久授权码
        String permanentCode = "B83ED308137C9653E543303740DB2533";
        JSONObject corpAccessTokenObj = getCorpAccessToken(appId,appSecret,permanentCode);
        corpAccessToken = corpAccessTokenObj.getString("corpAccessToken");
        corpId = corpAccessTokenObj.getString("corpId");

    }

    private JSONObject getCorpAccessToken(String appId, String appSecret, String permanentCode) throws Exception{
        Map<String,Object> obj = new HashMap<String, Object>();
        obj.put("appId",appId);
        obj.put("appSecret",appSecret);
        obj.put("permanentCode",permanentCode);
        String result = baseService.httpPostRequest(corpAccessTokenURL, obj);
        JSONObject jsonObject = JSONObject.parseObject(result);
        return jsonObject;
    }
}
