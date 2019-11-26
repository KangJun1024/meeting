package com.persagy.meeting.mapper;

import com.persagy.meeting.entity.MeetingType;
import com.persagy.meeting.entity.MeetingTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeetingTypeMapper {
    int countByExample(MeetingTypeExample example);

    int deleteByExample(MeetingTypeExample example);

    int deleteByPrimaryKey(String typeId);

    int insert(MeetingType record);

    int insertSelective(MeetingType record);

    List<MeetingType> selectByExample(MeetingTypeExample example);

    MeetingType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") MeetingType record, @Param("example") MeetingTypeExample example);

    int updateByExample(@Param("record") MeetingType record, @Param("example") MeetingTypeExample example);

    int updateByPrimaryKeySelective(MeetingType record);

    int updateByPrimaryKey(MeetingType record);
}