package com.persagy.meeting.controller;

import com.alibaba.fastjson.JSONObject;
import com.persagy.meeting.common.util.StringUtil;
import com.persagy.meeting.common.util.ToolsUtil;
import com.persagy.meeting.service.MeetingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restMeetingTypeService")
public class MeetingTypeController {

    @Autowired
    private MeetingTypeService meetingTypeService;

}
