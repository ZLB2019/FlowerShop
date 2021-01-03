package com.zlb.flower_shop.repository;

import com.zlb.flower_shop.bean.User;

import java.util.ArrayList;

public interface UserRepository {

    User selectUserByUser_id(Integer user_id);

    User selectUserByUser_email(String user_email);

    int insertUser(User user);

    int deleteByUser_id(Integer user_id);

    ArrayList<User> selectAllUser();

    int updateUser(User user);
}
