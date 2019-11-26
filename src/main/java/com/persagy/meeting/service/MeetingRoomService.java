package com.persagy.meeting.service;

import com.alibaba.fastjson.JSONObject;

public interface MeetingRoomService {

    /**
     * 新建 or 修改会议室
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String createMeetingRoom(JSONObject jsonObject) throws Exception;

    /**
     * 删除 or 停用会议室
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String deleteMeetingRoom(JSONObject jsonObject) throws Exception;

    /**
     * 会议室名称是否可用
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String verifyMeetingRoomName(JSONObject jsonObject) throws Exception;

    /**
     * 会议室列表
     *
     * @param jsonObject
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    String queryMeetingRoomList(JSONObject jsonObject) throws Exception;
}
