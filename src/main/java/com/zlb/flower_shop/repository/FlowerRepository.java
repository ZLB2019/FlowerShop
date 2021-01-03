package com.zlb.flower_shop.repository;

import com.zlb.flower_shop.bean.Flower;
import com.zlb.flower_shop.dto.FlowerDto;

import java.util.List;

public interface FlowerRepository {

    int insertFlower(Flower flower);

    int deleteFlower(Integer flowerId);

    List<FlowerDto> selectFlowerLike(String ans);

    Flower selectFlower(int flowerId);

    int updateFlower(Flower flower);
}
