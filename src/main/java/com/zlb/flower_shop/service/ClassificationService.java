package com.zlb.flower_shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlb.flower_shop.bean.Classification;
import com.zlb.flower_shop.mapper.ClassificationMapper;
import com.zlb.flower_shop.repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationService implements ClassificationRepository {

    @Autowired
    ClassificationMapper classificationMapper;

    @Override
    public int insertClass(Classification classification) {
        return classificationMapper.insert(classification);
    }

    @Override
    public int deleteClass(Integer classId) {
        return classificationMapper.deleteById(classId);
    }

    @Override
    public List<Classification> allClassification() {
        List<Classification> list;
        QueryWrapper<Classification> walletQueryWrapper = new QueryWrapper<>();
        walletQueryWrapper.select("class_id","class_name");
        list = classificationMapper.selectList(walletQueryWrapper);
        return list;
    }

    @Override
    public int updateClassification(Classification classification) {
        return classificationMapper.updateById(classification);
    }

    @Override
    public Classification selectClassByClassName(String class_name) {
        QueryWrapper<Classification> walletQueryWrapper = new QueryWrapper<>();
        walletQueryWrapper.select("class_id","class_name").eq("class_name",class_name);
        return classificationMapper.selectOne(walletQueryWrapper);
    }
}
