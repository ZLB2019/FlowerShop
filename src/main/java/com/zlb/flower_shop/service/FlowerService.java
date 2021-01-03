package com.zlb.flower_shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlb.flower_shop.bean.Classification;
import com.zlb.flower_shop.bean.Flower;
import com.zlb.flower_shop.bean.Vendor;
import com.zlb.flower_shop.dto.FlowerDto;
import com.zlb.flower_shop.mapper.ClassificationMapper;
import com.zlb.flower_shop.mapper.FlowerMapper;
import com.zlb.flower_shop.mapper.VendorMapper;
import com.zlb.flower_shop.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerService implements FlowerRepository {

    @Autowired
    FlowerMapper flowerMapper;

    @Autowired
    ClassificationMapper classificationMapper;

    @Autowired
    VendorMapper vendorMapper;

    @Override
    public int insertFlower(Flower flower) {
        return flowerMapper.insert(flower);
    }

    @Override
    public int deleteFlower(Integer flowerId) {
        return flowerMapper.deleteById(flowerId);
    }

    @Override
    public List<FlowerDto> selectFlowerLike(String ans) {
        List<Flower> flowerlist;
        List<FlowerDto> flowerDtoList = new ArrayList<>();
        QueryWrapper<Flower> flowerQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Classification> classQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Vendor> vendorQueryWrapper = new QueryWrapper<>();
        classQueryWrapper.eq("class_name",ans);
        vendorQueryWrapper.eq("vendor_name",ans);
        List<Classification> classificationList = classificationMapper.selectList(classQueryWrapper);
        List<Vendor> vendorList = vendorMapper.selectList(vendorQueryWrapper);

        flowerQueryWrapper.like("flower_name",ans).or().eq("price",ans);

        if(classificationList.size()>0)
            flowerQueryWrapper.or().eq("class_id",classificationList.get(0).getClassId());
        if(vendorList.size()>0)
            flowerQueryWrapper.or().eq("vendor_id",vendorList.get(0).getVendorId());

        flowerlist = flowerMapper.selectList(flowerQueryWrapper);
        for(Flower flower:flowerlist){
            FlowerDto flowerDto = new FlowerDto(flower);
            flowerDto.setClassName(classificationMapper.selectById(flower.getClassId()).getClassName());
            flowerDto.setVendorName(vendorMapper.selectById(flower.getVendorId()).getVendorName());
            flowerDtoList.add(flowerDto);
        }
        return flowerDtoList;
    }

    @Override
    public Flower selectFlower(int flowerId) {
        return flowerMapper.selectById(flowerId);
    }

    @Override
    public int updateFlower(Flower flower) {
        return flowerMapper.updateById(flower);
    }
}
