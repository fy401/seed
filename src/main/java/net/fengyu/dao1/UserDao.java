package net.fengyu.dao1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    @Insert("insert into t_user(userid,username,city,gender) values (#{userid},#{username},#{city},#{gender})")
    int insertUser(@Param("userid") int userid,@Param("username") String username,@Param("city") String city,@Param("gender") int gender);
}
