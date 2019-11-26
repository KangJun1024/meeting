package com.persagy.meeting.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.persagy.meeting.common.util.DateUtil;
import com.persagy.meeting.common.util.JSONUtil;
import com.persagy.meeting.common.util.StringUtil;
import com.persagy.meeting.common.util.ToolsUtil;
import com.persagy.meeting.entity.MeetingRoom;
import com.persagy.meeting.entity.MeetingRoomExample;
import com.persagy.meeting.mapper.MeetingRoomMapper;
import com.persagy.meeting.service.MeetingRoomService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("meetingRoomService")
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    private MeetingRoomMapper meetingRoomMapper;

    @Override
    public String createMeetingRoom(JSONObject jsonObject) throws Exception {
        //获取会议室参数
        String room_id = jsonObject.getString("room_id");
        String name = jsonObject.getString("name");
        String type_id = jsonObject.getString("type_id");
        String capacity = jsonObject.getString("capacity");
        JSONArray equipments = jsonObject.getJSONArray("equipments");
        JSONArray pictures = jsonObject.getJSONArray("pictures");
        //验证修改 or 添加
        if (room_id == null || "".equals(room_id)) {
            //添加
            //会议室ID
            String roomId = StringUtil.getDesignatedUUID("MR");
            MeetingRoom meetingRoom = new MeetingRoom();
            meetingRoom.setRoomId(roomId);
            meetingRoom.setName(name);
            meetingRoom.setTypeId(type_id);
            meetingRoom.setCapacity(capacity);
            meetingRoom.setEquipments(equipments.toJSONString());
            meetingRoom.setPictures(pictures.toJSONString());
            meetingRoom.setCreateTime(DateUtil.getNowTimeStr());
            meetingRoom.setUpdateTime(DateUtil.getNowTimeStr());
            meetingRoom.setStatus("1");
            meetingRoom.setValid(true);

            int insert = meetingRoomMapper.insert(meetingRoom);
            if(insert > 0){
                return ToolsUtil.successJsonMsg(roomId) ;
            }else {
                return ToolsUtil.errorJsonMsg("新建会议室失败");
            }
        }else{
            MeetingRoom meetingRoom = new MeetingRoom();
            meetingRoom.setName(name);
            meetingRoom.setTypeId(type_id);
            meetingRoom.setCapacity(capacity);
            meetingRoom.setEquipments(equipments.toJSONString());
            meetingRoom.setPictures(pictures.toJSONString());
            meetingRoom.setUpdateTime(DateUtil.getNowTimeStr());
            MeetingRoomExample meetingRoomExample = new MeetingRoomExample();
            MeetingRoomExample.Criteria criteria = meetingRoomExample.createCriteria();
            criteria.andRoomIdEqualTo(room_id);

            int i = meetingRoomMapper.updateByExampleSelective(meetingRoom, meetingRoomExample);
            if(i > 0){
                return ToolsUtil.successJsonMsg(room_id) ;
            }else {
                return ToolsUtil.errorJsonMsg("修改会议室失败");
            }
        }
    }

    @Override
    public String deleteMeetingRoom(JSONObject jsonObject) throws Exception {
        //获取会议室参数
        String room_id = jsonObject.getString("room_id");
        String status = jsonObject.getString("status"); ////1:启动;0:停用;2:删除
        if("0".equals(status)){
            //将状态置零
            MeetingRoom meetingRoom = new MeetingRoom();
            meetingRoom.setStatus(status);
            meetingRoom.setUpdateTime(DateUtil.getNowTimeStr());
            MeetingRoomExample meetingRoomExample = new MeetingRoomExample();
            MeetingRoomExample.Criteria criteria = meetingRoomExample.createCriteria();
            criteria.andRoomIdEqualTo(room_id);

            int i = meetingRoomMapper.updateByExampleSelective(meetingRoom, meetingRoomExample);
            if(i > 0){
                return ToolsUtil.successJsonMsg(room_id) ;
            }else {
                return ToolsUtil.errorJsonMsg("会议室停用失败");
            }

        }else if ("2".equals(status)){
            //将状态置2 valid为false
            MeetingRoom meetingRoom = new MeetingRoom();
            meetingRoom.setStatus(status);
            meetingRoom.setValid(false);
            meetingRoom.setUpdateTime(DateUtil.getNowTimeStr());
            MeetingRoomExample meetingRoomExample = new MeetingRoomExample();
            MeetingRoomExample.Criteria criteria = meetingRoomExample.createCriteria();
            criteria.andRoomIdEqualTo(room_id);

            int i = meetingRoomMapper.updateByExampleSelective(meetingRoom, meetingRoomExample);
            if(i > 0){
                return ToolsUtil.successJsonMsg(room_id) ;
            }else {
                return ToolsUtil.errorJsonMsg("会议室删除失败");
            }
        }

        return ToolsUtil.successJsonMsg("SUCCESS");
    }

    @Override
    public String verifyMeetingRoomName(JSONObject jsonObject) throws Exception {
        boolean can_use = true;
        //获取会议室参数
        String room_id = jsonObject.getString("room_id");
        String room_name = jsonObject.getString("room_name");
        //0. 获取id name集合
        Map<String, String> roomId2Name = getId2NameMap();
        //1. 查询项目下所有建筑（RelatedSchedule 公告ID）
        if (roomId2Name.containsValue(room_name)) {
            can_use = false;
        }
        if (room_id != null && room_name.equals(roomId2Name.get(room_id))) {
            can_use = true;
        }
        jsonObject.clear();
        jsonObject.put("Result", "success");
        JSONObject item = new JSONObject();
        item.put("can_use", can_use);
        jsonObject.put("Content", item);
        jsonObject.put("ResultMsg", "");
        return jsonObject.toJSONString();
    }

    @Override
    public String queryMeetingRoomList(JSONObject jsonObject) throws Exception {
        //获取会议室参数
        //搜索关键字
        String keyword = jsonObject.getString("keyword");
        JSONArray resultArr = new JSONArray();
        List<MeetingRoom> meetingRooms = meetingRoomMapper.selectByExample(new MeetingRoomExample());
        if (meetingRooms != null && meetingRooms.size() > 0) {
            //过滤条件
            if (StringUtils.isNotBlank(keyword)) {
                //根据关键字过滤会议室名称
                List<MeetingRoom> filtrationRoom = new ArrayList<MeetingRoom>();
                Pattern pattern = Pattern.compile(keyword);
                for (MeetingRoom meetingRoom : meetingRooms) {
                    Matcher matcher = pattern.matcher(meetingRoom.getName());
                    if(matcher.find()){
                        filtrationRoom.add(meetingRoom);
                    }
                }
                meetingRooms = filtrationRoom;
            }
        }
        //封装返回参数
        if(meetingRooms.size() <= 0){
            return ToolsUtil.successJsonMsg(new JSONArray());
        }
        for (MeetingRoom meetingRoom : meetingRooms) {
            JSONObject resultObj = new JSONObject();
            resultObj.put("room_id",meetingRoom.getRoomId());
            resultObj.put("name",meetingRoom.getName());
            resultObj.put("capacity",meetingRoom.getCapacity());
            resultObj.put("pictures",JSONArray.parseArray(meetingRoom.getPictures()));
            resultObj.put("equipments",JSONArray.parseArray(meetingRoom.getEquipments()));
            resultObj.put("type_id",meetingRoom.getTypeId());
            resultObj.put("type_name","类型");
            resultObj.put("status",meetingRoom.getStatus());
            resultArr.add(resultObj);
        }
        return ToolsUtil.successJsonMsg(resultArr);
    }

    /**
     * @return
     */
    private Map<String, String> getId2NameMap() throws Exception{
        Map<String, String> map = new HashMap<>();
        String roomList = this.queryMeetingRoomList(new JSONObject());
        JSONObject object = JSONObject.parseObject(roomList);

        if(object != null && "success".equals(object.getString("Result"))){
            JSONArray jsonArray = object.getJSONArray("Content");
            if(!JSONUtil.arrayIsBlank(jsonArray)){
                for (Object o : jsonArray) {
                    JSONObject obj = (JSONObject) o;
                    map.put(obj.getString("room_id"),obj.getString("name"));
                }
            }
        }


        return map;
    }
}
