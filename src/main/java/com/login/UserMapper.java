package com.login;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id as uid,userid as userId,username as userName,realname as realName,email,photoUrl from localUser where username=#{userName} AND password=#{password}")
    User verifyLogin(@Param("userName") String userName, @Param("password") String password);
}

