package com.dgwl.dao;

import com.dgwl.eo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {


    User selectUser(@Param("userName") String userName, @Param("password") String password);

    Integer updateUser(User user);

}
