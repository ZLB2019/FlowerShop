package com.zlb.flower_shop.controller;

import com.zlb.flower_shop.bean.Car;
import com.zlb.flower_shop.dto.CarDto;
import com.zlb.flower_shop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 购物车处理
 */
@RestController
@Controller
@RequestMapping("car")
public class ShopCar {
    @Autowired
    CarService carService;

    /***
    功能描述 :返回该用户的购物车内的所有商品
    * @author zlb
    * @date 2020/10/22
    * @param [userId]
    * @return java.util.List<com.zlb.flower_shop.dto.CarDto>
    */
    @RequestMapping("allCar")
    public List<CarDto> allCar(Integer userId){
        return carService.selectCarByUserId(userId);
    }

    /***
     功能描述 :更新购物车
     * @author zlb
     * @date 2020/10/28
     * @param [car]
     * @return int
     */
    @RequestMapping("updateCar")
    public int updateCar(Car car){
        return  carService.updateCar(car);
    }

    /***
    功能描述 :删除购物车内某商品
    * @author zlb
    * @date 2020/10/28
    * @param [carId]
    * @return int
    */
    @RequestMapping("delCar")
    public int delCar(Integer carId){
        return carService.deleteCar(carId);
    }
}
