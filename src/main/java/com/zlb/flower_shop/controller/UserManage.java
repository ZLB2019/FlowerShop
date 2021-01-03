package com.zlb.flower_shop.controller;

import com.zlb.flower_shop.bean.User;
import com.zlb.flower_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 用户管理
 */
@Controller
@ResponseBody
@RequestMapping("UserManage")
public class UserManage {

    @Autowired
    UserService userService;

    /**
    功能描述 :返回所有用户
    * @author zlb
    * @date 2020/9/28
    * @return java.util.List<com.zlb.flower_shop.bean.User>
    */
    @RequestMapping("all_user")
    public List<User> all_user(){
        return userService.selectAllUser();
    }

    /**
    功能描述 : 根据邮箱返回一个用户
    * @author zlb
    * @date 2020/9/28
    * @param [user_email]
    * @return com.zlb.flower_shop.bean.User
    */
    @RequestMapping("selectUserByEmail")
    public User selectUserByEmail(String user_email){
        return userService.selectUserByUser_email(user_email);
    }

    @RequestMapping("DeleteUser")
    public int DeleteUser(int userId){
        return userService.deleteByUser_id(userId);
    }

    /**
    功能描述 :添加用户
    * @author zlb
    * @date 2020/9/28
    * @param [user]
    * @return int
    */
    @RequestMapping("insert_user")
    public int insert_user(User user){
        return userService.insertUser(user);
    }

    /**
    功能描述 :修改用户信息
    * @author zlb
    * @date 2020/9/28
    * @param [user]
    * @return int
    */
    @RequestMapping("UpdateUser")
    public int UpdateUser(User user){
        System.out.println(user);
        return userService.updateUser(user);
    }
}
