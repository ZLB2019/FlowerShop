package com.zlb.flower_shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlb.flower_shop.bean.Car;
import com.zlb.flower_shop.bean.Flower;
import com.zlb.flower_shop.dto.CarDto;
import com.zlb.flower_shop.mapper.CarMapper;
import com.zlb.flower_shop.mapper.FlowerMapper;
import com.zlb.flower_shop.repository.CarRepesitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService implements CarRepesitory {

    @Autowired
    CarMapper carMapper;

    @Autowired
    FlowerMapper flowerMapper;

    @Override
    public int insertCar(Car car) {
        return carMapper.insert(car);
    }

    @Override
    public int deleteCar(Integer CarId) {
        return carMapper.deleteById(CarId);
    }

    @Override
    public List<CarDto> selectCarByUserId(Integer userId) {
        QueryWrapper<Car> walletQueryWrapper = new QueryWrapper<>();
        walletQueryWrapper.eq("user_id",userId);
        List<Car> list= carMapper.selectList(walletQueryWrapper);
        List<CarDto> carDtos = new ArrayList<>();
        for(Car car:list){
            Flower flower = flowerMapper.selectById(car.getFlowerId());
            CarDto carDto = new CarDto(flower);
            carDto.setCarId(car.getCarId());
            carDto.setNumber(car.getNumber());
            carDto.setUserId(car.getUserId());
            carDtos.add(carDto);
        }
        return carDtos;
    }

    @Override
    public int updateCar(Car car) {
        return carMapper.updateById(car);
    }
}
