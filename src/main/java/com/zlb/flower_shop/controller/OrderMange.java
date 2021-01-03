package com.zlb.flower_shop.controller;

import com.zlb.flower_shop.bean.Orders;
import com.zlb.flower_shop.dto.OrderDto;
import com.zlb.flower_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 订单管理
 */
@RestController
@Controller
@RequestMapping("orderManage")
public class OrderMange {
    @Autowired
    OrderService orderService;

    /***
     功能描述 :查找所有订单
     * @author zlb
     * @date 2020/10/23
     * @param [userId, type]
     * @return java.util.List<com.zlb.flower_shop.dto.OrderDto>
     */
    @RequestMapping("allOrder")
    public List<OrderDto> allOrder(){
        return orderService.selectOrderByUserId("",0,0);
    }

    /***
    功能描述 :按类型查找订单
    * @author zlb
    * @date 2020/10/23
    * @param [userId, type]
    * @return java.util.List<com.zlb.flower_shop.dto.OrderDto>
    */
    @RequestMapping("selectOrder")
    public List<OrderDto> selectOrder(String userEmail,Integer type){
        return orderService.selectOrderByUserId(userEmail,type,1);
    }

    /***
    功能描述 :更新订单
    * @author zlb
    * @date 2020/10/23
    * @param [orders]
    * @return int
    */
    @RequestMapping("updateOrder")
    public int updateOrder(Orders orders){
        return orderService.updateOrder(orders);
    }

    /***
    功能描述 :删除订单
    * @author zlb
    * @date 2020/10/23
    * @param [orderId]
    * @return int
    */
    @RequestMapping("deleteOrder")
    public int deleteOrder(Integer orderId){
        return orderService.deleteOrder(orderId);
    }

    /***
    功能描述 :添加订单
    * @author zlb
    * @date 2020/10/26
    * @param [orders]
    * @return int
    */
    @RequestMapping("insertOrder")
    public int insertOrder(Orders orders){
        return orderService.insertOrder(orders);
    }
}
