package com.zlb.flower_shop.controller;

import com.zlb.flower_shop.dto.OrderDto;
import com.zlb.flower_shop.service.OrderService;
import com.zlb.flower_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 我的订单处理
 */
@RestController
@RequestMapping("order")
public class Order {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    /**
    功能描述 :根据用户id，返回该用户的所有订单
    * @author zlb
    * @date 2020/11/16
    * @param [userId]
    * @return java.util.List<com.zlb.flower_shop.dto.OrderDto>
    */
    @RequestMapping("userAllOrder")
    public List<OrderDto> userAllOrder(Integer userId){
        return orderService.selectOrderByUserId(userService.selectUserByUser_id(userId).getUserEmail(),-1,-1);
    }
}
