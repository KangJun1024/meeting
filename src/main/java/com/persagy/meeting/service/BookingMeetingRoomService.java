package com.persagy.meeting.service;

import com.alibaba.fastjson.JSONObject;
import com.persagy.meeting.entity.BookingMeetingRoom;

public interface BookingMeetingRoomService {

    /**
     * 预约变更会议室
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String bookingOrUpdateMeeting(JSONObject jsonObject) throws Exception;

    /**
     * 取消删除会议
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String cancelOrDeleteMeeting(JSONObject jsonObject) throws Exception;

    /**
     * 我组织的会议
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String queryMyCreatedMeeting(JSONObject jsonObject) throws Exception;

    /**
     * 我参加的会议
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String queryMyParticipantMeeting(JSONObject jsonObject) throws Exception;

    /**
     * 开始会议
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String startMeeting(JSONObject jsonObject) throws Exception;

    /**
     * 发送消息
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String sendMessage(JSONObject jsonObject) throws Exception;

    /**
     * 会议详情
     *
     * @param booking_room_id
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    BookingMeetingRoom queryMeetingDetail(String booking_room_id) throws Exception;


}
