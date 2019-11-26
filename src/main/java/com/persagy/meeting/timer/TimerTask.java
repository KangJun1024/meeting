package com.persagy.meeting.timer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.persagy.meeting.common.CommonConst;
import com.persagy.meeting.common.util.JSONUtil;
import com.persagy.meeting.common.util.ToolsUtil;
import com.persagy.meeting.entity.BookingMeetingRoom;
import com.persagy.meeting.entity.BookingMeetingRoomExample;
import com.persagy.meeting.mapper.BookingMeetingRoomMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * TimerTask.java 
 * Description:  定时任务
 * @author kangjun
 * @since 2019年11月27日:下午3:41:41
 */
//@Component
@Deprecated
public class TimerTask {

    @Autowired
    private BookingMeetingRoomMapper bookingMeetingRoomMapper;

    private final static Logger log = LoggerFactory.getLogger(TimerTask.class);

    /**
     * Description:  每隔15min定时更新会议室的开始情况
     * @since 2019年11月21日:下午3:42:29
     * @author kangjun
     */
    @Scheduled(cron = "0 /15 * * * ?")
    public void updateMeetingState() {
        //创建当前时间(格式：yyyy-MM-dd)
        LocalDate today = LocalDate.now();
        //创建时间格式工具
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonConst.date_format_save);

        try {
            log.info("update meeting state starting....");

            //查询会议
            //封装参数 未开始的会议
            BookingMeetingRoomExample bookingMeetingRoomExample = new BookingMeetingRoomExample();
            BookingMeetingRoomExample.Criteria criteria = bookingMeetingRoomExample.createCriteria();
            criteria.andValidEqualTo(true);
            criteria.andStatusEqualTo("O"); //0:已预约;1:已开始;2:已结束;3:已取消
            List<BookingMeetingRoom> bookingMeetingRooms = bookingMeetingRoomMapper.selectByExample(bookingMeetingRoomExample);

            if (bookingMeetingRooms == null || bookingMeetingRooms.isEmpty()) {
                log.info("no data in empty database");
                return;
            }

            String meeting = null;

            //将要求结束时间和当前时间比较
            for (int i = 0, size = bookingMeetingRooms.size(); i < size; i++) {
                BookingMeetingRoom bookingMeetingRoom = bookingMeetingRooms.get(i);
                String meetingStartTime = bookingMeetingRoom.getMeetingStartTime();

                //判断ask_end_time的有效性
                if (!StringUtils.equals("", meetingStartTime) && StringUtils.isNumeric(meetingStartTime)) {
                    //检查ask_end_time的格式是否为规定的日期格式
                    if (CommonConst.date_format_save.length() != meetingStartTime.length()) {
                        continue;
                    }

                    //转换为LocalDate格式的日期类型
                    LocalDate startDate = LocalDate.parse(meetingStartTime, formatter);
                    //当前时间大于要求结束时间
                    if (today.isEqual(startDate) || today.isAfter(startDate)) {
                        meeting = bookingMeetingRoom.getBookiongRoomId();
                        //TODO 待优化
                        BookingMeetingRoom bookingMeeting = new BookingMeetingRoom();
                        bookingMeeting.setStatus("1");
                        BookingMeetingRoomExample bookingMeetingExample = new BookingMeetingRoomExample();
                        BookingMeetingRoomExample.Criteria criteria2 = bookingMeetingExample.createCriteria();
                        criteria2.andBookingPersonIdEqualTo(meeting);


                        log.info(MessageFormat.format("state of bookingId:[{0}] be updated", meeting));
                    }
                }

            }

            log.info("update task overdue state failed");

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
