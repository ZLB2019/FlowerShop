package com.zlb.flower_shop.repository;

import com.zlb.flower_shop.bean.Classification;

import java.util.List;

public interface ClassificationRepository {

    Classification selectClassByClassName(String class_name);

    int insertClass(Classification classification);

    int deleteClass(Integer classId);

    List<Classification> allClassification();

    int updateClassification(Classification classification);
}
