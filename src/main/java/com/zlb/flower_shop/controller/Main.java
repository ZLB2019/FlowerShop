package com.zlb.flower_shop.controller;

import com.zlb.flower_shop.bean.Car;
import com.zlb.flower_shop.bean.Flower;
import com.zlb.flower_shop.bean.Orders;
import com.zlb.flower_shop.bean.User;
import com.zlb.flower_shop.dto.FlowerDto;
import com.zlb.flower_shop.service.CarService;
import com.zlb.flower_shop.service.FlowerService;
import com.zlb.flower_shop.service.OrderService;
import com.zlb.flower_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 主页处理
 */
@RequestMapping("main")
@RestController
public class Main {

    @Autowired
    UserService userService;

    @Autowired
    FlowerService flowerService;

    @Autowired
    CarService carService;

    @Autowired
    OrderService orderService;

    @RequestMapping("allFlower")
    public List<FlowerDto> allFlower(String ans) {
        return flowerService.selectFlowerLike(ans);
    }


    /***
    功能描述 :
    * @author zlb
    * @date 2020/10/15
    * @param [userId]
    * @return com.zlb.flower_shop.bean.User
    */
    @RequestMapping("selectUserById")
    public User selectUserById(Integer userId){
        return userService.selectUserByUser_id(userId);
    }

    /***
     功能描述 :添加到购物车
     * @author zlb
     * @date 2020/10/22
     * @param [car]
     * @return int
     */
    @RequestMapping("addCar")
    public int addCar(Car car){
        return carService.insertCar(car);
    }

    /***
     功能描述 :添加到购物车
     * @author zlb
     * @date 2020/10/22
     * @param [car]
     * @return int
     */
    @RequestMapping("addOrder")
    public int addOrder(Orders order){
        Flower flower = flowerService.selectFlower(order.getFlowerId());
        if(order.getNumber()<=0||order.getNumber()>flower.getNumber())
            return 0;
        flower.setNumber(flower.getNumber()-order.getNumber());
        flowerService.updateFlower(flower);
        return orderService.insertOrder(order);
    }


}

