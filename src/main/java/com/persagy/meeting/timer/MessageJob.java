package com.persagy.meeting.timer;

import com.alibaba.fastjson.JSONObject;
import com.persagy.meeting.service.BookingMeetingRoomService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Description:   会议消息提醒任务
 * Company: Persagy
 *
 * @author kangjun
 * @version 1.0
 * @since: 2019年11月22日: 下午6:03:12
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MessageJob extends QuartzJobBean {
    @Autowired
    private BookingMeetingRoomService bookingMeetingRoomService;

    //业务注入属性值
    private String bookiongRoomId;
    private String roomId;
    private String roomName;
    private String bookingPersonId;
    private String bookingPersonName;
    private String bookingPersonPicture;
    private String participants;
    private String meetingStartTime;
    private String meetingEndTime;
    private String topic;
    private String meetingReminders;
    private String createTime;
    private String updateTime;
    private String status;
    private Boolean valid;

    private static final Logger log = LoggerFactory.getLogger(MessageJob.class);
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        log.info("=========================================MessageJob任务开始==========================================");
        // 应该触发时间
        Date scheduledFireTime = context.getScheduledFireTime();
        // 实际触发时间
        Date fireTime = context.getFireTime();
        //发送消息
        try {
            bookingMeetingRoomService.sendMessage(new JSONObject());
        }catch (Exception e){

        }
    }

    public String getBookiongRoomId() {
        return bookiongRoomId;
    }

    public void setBookiongRoomId(String bookiongRoomId) {
        this.bookiongRoomId = bookiongRoomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBookingPersonId() {
        return bookingPersonId;
    }

    public void setBookingPersonId(String bookingPersonId) {
        this.bookingPersonId = bookingPersonId;
    }

    public String getBookingPersonName() {
        return bookingPersonName;
    }

    public void setBookingPersonName(String bookingPersonName) {
        this.bookingPersonName = bookingPersonName;
    }

    public String getBookingPersonPicture() {
        return bookingPersonPicture;
    }

    public void setBookingPersonPicture(String bookingPersonPicture) {
        this.bookingPersonPicture = bookingPersonPicture;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getMeetingStartTime() {
        return meetingStartTime;
    }

    public void setMeetingStartTime(String meetingStartTime) {
        this.meetingStartTime = meetingStartTime;
    }

    public String getMeetingEndTime() {
        return meetingEndTime;
    }

    public void setMeetingEndTime(String meetingEndTime) {
        this.meetingEndTime = meetingEndTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMeetingReminders() {
        return meetingReminders;
    }

    public void setMeetingReminders(String meetingReminders) {
        this.meetingReminders = meetingReminders;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
