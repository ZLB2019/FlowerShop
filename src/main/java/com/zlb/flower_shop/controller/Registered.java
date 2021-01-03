package com.zlb.flower_shop.controller;

import com.zlb.flower_shop.bean.User;
import com.zlb.flower_shop.model.Mail;
import com.zlb.flower_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 注册处理
 */
@Controller
@ResponseBody
@RequestMapping("registered")
public class Registered {

    @Autowired
    UserService userService;

    /**
    功能描述 :如果注册成功则向数据库添加一个用户，否则返回错误提示信息
    * @author zlb
    * @date 2020/9/29
    * @param [user, VerificationCode, session]
    * @return int
    */
    @RequestMapping("insertUser")
    public int insertUser(User user,String VerificationCode,HttpSession session){
        //System.out.println(user+"VerificationCode ="+VerificationCode);
        if(session.getAttribute(user.getUserEmail())==null)
            return -1;
        if (session.getAttribute(user.getUserEmail()).equals(VerificationCode)){
            return userService.insertUser(user);
        }else
            return 0;
    }

    /**
    功能描述 :发送验证码
    * @author zlb
    * @date 2020/9/29
    * @param [user_email, session]
    * @return boolean
    */
    @RequestMapping("sendMessage")
    public boolean sendMessage(String user_email, HttpSession session) throws Exception{
        User user = userService.selectUserByUser_email(user_email);
        if(user!=null)
            return false;
        else{
            session.setAttribute(user_email,Mail.SendMail(user_email));
            return true;
        }
    }

}
