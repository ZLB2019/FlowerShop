package com.zlb.flower_shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlb.flower_shop.bean.User;
import com.zlb.flower_shop.mapper.UserMapper;
import com.zlb.flower_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserRepository {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByUser_id(Integer user_id) {
        return userMapper.selectById(user_id);
    }

    @Override
    public User selectUserByUser_email(String user_email) {
        QueryWrapper<User> walletQueryWrapper = new QueryWrapper<>();
        walletQueryWrapper.select("user_id","user_email","user_password")
                .eq("user_email",user_email);
        return userMapper.selectOne(walletQueryWrapper);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteByUser_id(Integer user_id) {
        return userMapper.deleteById(user_id);
    }

    @Override
    public ArrayList<User> selectAllUser() {
        QueryWrapper<User> walletQueryWrapper = new QueryWrapper<>();
        walletQueryWrapper.select("user_id","user_email","user_password");
        return (ArrayList)userMapper.selectList(walletQueryWrapper);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }
}
