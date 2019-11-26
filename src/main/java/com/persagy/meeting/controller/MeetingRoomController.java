package com.persagy.meeting.controller;

import com.alibaba.fastjson.JSONObject;
import com.persagy.meeting.common.util.StringUtil;
import com.persagy.meeting.common.util.ToolsUtil;
import com.persagy.meeting.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restMeetingRoomService")
public class MeetingRoomController {

    @Autowired
    private MeetingRoomService meetingRoomService;

    /**
     * 新建 or 修改会议室
     *
     * @param jsonStr
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    @PostMapping("/createMeetingRoom")
    public String createMeetingRoom(@RequestBody String jsonStr) throws Exception{

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        if (StringUtil.isNull(jsonObject, "name")) {
            return ToolsUtil.lackParamErrorJsonMsg("name");
        }
        if (StringUtil.isNull(jsonObject, "type_id")) {
            return ToolsUtil.lackParamErrorJsonMsg("type_id");
        }
        if (StringUtil.isNull(jsonObject, "capacity")) {
            return ToolsUtil.lackParamErrorJsonMsg("capacity");
        }

        return meetingRoomService.createMeetingRoom(jsonObject);
    }

    /**
     * 删除 or 停用会议室
     *
     * @param jsonStr
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    @PostMapping("/deleteMeetingRoom")
    public String deleteMeetingRoom(@RequestBody String jsonStr) throws Exception{

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        if (StringUtil.isNull(jsonObject, "room_id")) {
            return ToolsUtil.lackParamErrorJsonMsg("room_id");
        }
        if (StringUtil.isNull(jsonObject, "status")) { //1:启动;0:停用;2:删除
            return ToolsUtil.lackParamErrorJsonMsg("status");
        }

        return meetingRoomService.deleteMeetingRoom(jsonObject);
    }

    /**
     * 会议室名称是否可用
     *
     * @param jsonStr
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    @PostMapping("/verifyMeetingRoomName")
    public String verifyMeetingRoomName(@RequestBody String jsonStr) throws Exception{

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        if (StringUtil.isNull(jsonObject, "room_name")) {
            return ToolsUtil.lackParamErrorJsonMsg("room_name");
        }

        return meetingRoomService.verifyMeetingRoomName(jsonObject);
    }

    /**
     * 会议室列表
     *
     * @param jsonStr
     * @return String
     * @date 2019年11月13日: 下午4:07:32
     * @author kangjun
     * @version 1.0
     */
    @PostMapping("/queryMeetingRoomList")
    public String queryMeetingRoomList(@RequestBody String jsonStr) throws Exception{

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        return meetingRoomService.queryMeetingRoomList(jsonObject);
    }
}
