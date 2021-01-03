package com.zlb.flower_shop.controller;

import com.zlb.flower_shop.bean.Administrator;
import com.zlb.flower_shop.bean.User;
import com.zlb.flower_shop.service.AdministratorService;
import com.zlb.flower_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 登录处理
 */
@Controller
@ResponseBody
@RequestMapping("login")
public class Login {

    @Autowired
    UserService userService;
    @Autowired
    AdministratorService administratorService;


    /**
    功能描述 :登录判断
    * @author zlb
    * @date 2020/9/29
    * @param [user]
    * @return int
    */
    @RequestMapping("loginJudge")
    public int loginJudge(User user){
        /**
         * 特殊判断，判断是否为管理员
         */
        Administrator administrator =  administratorService.selectAdministrator(user.getUserEmail());
        if(administrator!=null&&administrator.getAdministratorAccount().equals(user.getUserPassword())){
            return -1;
        }

        User user1 = userService.selectUserByUser_email(user.getUserEmail());

        /**
         * 如果user1为空，表明id不存在，或者密码不匹配，则登录失败
         */
        if(user1 == null||!user1.getUserPassword().equals(user.getUserPassword())){
          return 0;
        }else{
            return user1.getUserId();
        }
    }
}
