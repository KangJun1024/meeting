package com.persagy.meeting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "booking_meeting_room",indexes = {

})
public class BookingMeetingRoom implements Serializable {
    @Id
    @Column(name = "booking_room_id",length = 36)
    private String bookingRoomId;
    @Column(name = "room_id",length = 36)
    private String roomId;
    @Column(name = "room_name",length = 100)
    private String roomName;
    @Column(name = "booking_person_id",length = 36)
    private String bookingPersonId;
    @Column(name = "booking_person_name",length = 100)
    private String bookingPersonName;
    @Column(name = "booking_person_picture",length = 36)
    private String bookingPersonPicture;
    @Column(name = "participants",length = 1000)
    private String participants;
    @Column(name = "meeting_start_time",nullable = false)
    private String meetingStartTime;
    @Column(name = "meeting_end_time",nullable = false)
    private String meetingEndTime;
    @Column(name = "topic",length = 100)
    private String topic;
    @Column(name = "meeting_reminders",length = 100) //0:准时提醒;1:提前15min;2:提前1h;3:提前2小时
    private String meetingReminders;
    @Column(name = "create_time",nullable = false)
    private String createTime;
    @Column(name = "update_time",nullable = false)
    private String updateTime;
    @Column(name = "status",length = 1,nullable = false) //0:已预约;1:已开始;2:已结束;3:已取消
    private String status;
    @Column(name = "valid",length = 1,nullable = false)
    private Boolean valid;

    private static final long serialVersionUID = 1L;

    public String getBookiongRoomId() {
        return bookingRoomId;
    }

    public void setBookiongRoomId(String bookiongRoomId) {
        this.bookingRoomId = bookiongRoomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

}