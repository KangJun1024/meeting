package com.persagy.meeting.mapper;

import com.persagy.meeting.entity.TUser;
import com.persagy.meeting.entity.TUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserMapper {
    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(String cUserId);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExampleWithBLOBs(TUserExample example);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(String cUserId);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExampleWithBLOBs(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKeyWithBLOBs(TUser record);

    int updateByPrimaryKey(TUser record);
}