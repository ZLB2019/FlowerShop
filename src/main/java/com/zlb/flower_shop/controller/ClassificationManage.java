package com.zlb.flower_shop.controller;


import com.zlb.flower_shop.bean.Classification;
import com.zlb.flower_shop.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
分类管理
*/
@Controller
@ResponseBody
@RequestMapping("ClassManage")
public class ClassificationManage {

    @Autowired
    ClassificationService classificationService;

    /**
    功能描述 :返回所有分类
    * @author zlb
    * @date 2020/9/29
    * @param []
    * @return java.util.List<com.zlb.flower_shop.controller.ClassificationManage>
    */

    @RequestMapping("allClass")
    public List<Classification> allClass(){
        return classificationService.allClassification();
    }

    /**
    功能描述 :添加分类
    * @author zlb
    * @date 2020/9/29
    * @param [classification]
    * @return int
    */
    @RequestMapping("insertClass")
    public int insertClass(Classification classification){
        return classificationService.insertClass(classification);
    }

    /**
    功能描述 :删除分类
    * @author zlb
    * @date 2020/9/29
    * @param [classId]
    * @return int
    */
    @RequestMapping("deleteClass")
    public int deleteClass(Integer classId){
        return classificationService.deleteClass(classId);
    }

    /**
    功能描述 :修改分类名
    * @author zlb
    * @date 2020/9/29
    * @param [classification]
    * @return int
    */
    @RequestMapping("updateClass")
    public int updateClass(Classification classification){
        return classificationService.updateClassification(classification);
    }

    /***
    功能描述 :根据分类名查询分类
    * @author zlb
    * @date 2020/10/2
    * @param [className]
    * @return com.zlb.flower_shop.bean.Classification
    */
    @RequestMapping("selectClass")
    public Classification selectClass(String className){
        return classificationService.selectClassByClassName(className);
    }
}
