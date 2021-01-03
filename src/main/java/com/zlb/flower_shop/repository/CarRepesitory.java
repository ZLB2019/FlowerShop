package com.zlb.flower_shop.repository;

import com.zlb.flower_shop.bean.Car;
import com.zlb.flower_shop.dto.CarDto;

import java.util.List;

public interface CarRepesitory {

    int insertCar(Car car);

    int deleteCar(Integer CarId);

    List<CarDto> selectCarByUserId(Integer userId);

    int updateCar(Car car);
}
