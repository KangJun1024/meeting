package com.persagy.meeting.mapper;

import com.persagy.meeting.entity.BookingMeetingRoom;
import com.persagy.meeting.entity.BookingMeetingRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookingMeetingRoomMapper {
    int countByExample(BookingMeetingRoomExample example);

    int deleteByExample(BookingMeetingRoomExample example);

    int deleteByPrimaryKey(String bookingRoomId);

    int insert(BookingMeetingRoom record);

    int insertSelective(BookingMeetingRoom record);

    List<BookingMeetingRoom> selectByExample(BookingMeetingRoomExample example);

    BookingMeetingRoom selectByPrimaryKey(String bookingRoomId);

    int updateByExampleSelective(@Param("record") BookingMeetingRoom record, @Param("example") BookingMeetingRoomExample example);

    int updateByExample(@Param("record") BookingMeetingRoom record, @Param("example") BookingMeetingRoomExample example);

    int updateByPrimaryKeySelective(BookingMeetingRoom record);

    int updateByPrimaryKey(BookingMeetingRoom record);
}