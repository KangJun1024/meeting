package com.persagy.meeting.controller;

import com.alibaba.fastjson.JSONObject;
import com.persagy.meeting.common.util.StringUtil;
import com.persagy.meeting.common.util.ToolsUtil;
import com.persagy.meeting.service.BookingMeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restBookingMeetingRoomService")
public class BookingMeetingRoomController {

    @Autowired
    private BookingMeetingRoomService bookingMeetingRoomService;

    /**
     * 预约 or 变更会议室
     *
     * @param jsonStr
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    @PostMapping("/bookingOrUpdateMeeting")
    public String bookingOrUpdateMeeting(@RequestBody String jsonStr) throws Exception{

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        if (StringUtil.isNull(jsonObject, "booking_person_id")) {
            return ToolsUtil.lackParamErrorJsonMsg("booking_person_id");
        }
        if (StringUtil.isNull(jsonObject, "meeting_start_time")) {
            return ToolsUtil.lackParamErrorJsonMsg("meeting_start_time");
        }
        if (StringUtil.isNull(jsonObject, "meeting_end_time")) {
            return ToolsUtil.lackParamErrorJsonMsg("meeting_end_time");
        }
        if (StringUtil.isNull(jsonObject, "topic")) {
            return ToolsUtil.lackParamErrorJsonMsg("topic");
        }

        return bookingMeetingRoomService.bookingOrUpdateMeeting(jsonObject);
    }

    /**
     * 取消删除会议
     *
     * @param jsonStr
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    @PostMapping("/cancelOrDeleteMeeting")
    public String cancelOrDeleteMeeting(@RequestBody String jsonStr) throws Exception{

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        if (StringUtil.isNull(jsonObject, "booking_room_id")) {
            return ToolsUtil.lackParamErrorJsonMsg("booking_room_id");
        }
        if (StringUtil.isNull(jsonObject, "status")) {
            return ToolsUtil.lackParamErrorJsonMsg("status");
        }

        return bookingMeetingRoomService.cancelOrDeleteMeeting(jsonObject);
    }

    /**
     * 我组织的会议
     *
     * @param jsonStr
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    @PostMapping("/queryMyCreatedMeeting")
    public String queryMyCreatedMeeting(@RequestBody String jsonStr) throws Exception{

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        if (StringUtil.isNull(jsonObject, "user_name")) {
            return ToolsUtil.lackParamErrorJsonMsg("user_name");
        }

        return bookingMeetingRoomService.queryMyCreatedMeeting(jsonObject);
    }

    /**
     * 我参加的会议
     *
     * @param jsonStr
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    @PostMapping("/queryMyParticipantMeeting")
    public String queryMyParticipantMeeting(@RequestBody String jsonStr) throws Exception{

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        if (StringUtil.isNull(jsonObject, "user_name")) {
            return ToolsUtil.lackParamErrorJsonMsg("user_name");
        }

        return bookingMeetingRoomService.queryMyParticipantMeeting(jsonObject);
    }
}
