package com.zlb.flower_shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlb.flower_shop.bean.Flower;
import com.zlb.flower_shop.dto.FlowerDto;
import com.zlb.flower_shop.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 商品管理
 */
@RequestMapping("FlowerManage")
@RestController
public class FlowerManage {

    @Autowired
    FlowerService flowerService;

    @RequestMapping("selectFlowerLike")
    public List<FlowerDto> selectFlowerLike(String ans) {
        return flowerService.selectFlowerLike(ans);
    }

    @RequestMapping("insertFlower")
    public int insertFlower(Flower flower){
        return flowerService.insertFlower(flower);
    }

    /**
     * 上传图片
     *
     * @param image   图片文件
     * @param request 请求
     * @return 上传成功的url, 或成功与否提示信息
     */
    @PostMapping("/upload")
    public Object upload(MultipartFile image) {
        JSONObject response = new JSONObject();
        String baseFolderPath =Objects.requireNonNull(this.getClass().getClassLoader().getResource("static/image/flower")).getFile();
        //文件上传的文件夹路径为baseFolderPath
        File baseFolder = new File(baseFolderPath);
        if (!baseFolder.exists()) {
            baseFolder.mkdirs();
        }
        System.out.println(image);
        //图片名为当前时间戳+原始图片名去掉空格
        String imgName = System.currentTimeMillis() + image.getOriginalFilename().replaceAll(" ", "");
        //目标文件
        File dest = new File(baseFolder, imgName);
        System.out.println(dest);
        try {
            //使用FileCopyUtils将图片比特流复制到目的文件夹中
            FileCopyUtils.copy(image.getBytes(), dest);

            //图片回显路径
            StringBuffer url = new StringBuffer();
            url.append("image/flower/")
                    .append(imgName);
            response.put("url", url);
            response.put("message", "success");
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
            response.put("message", "fail");
        }
        return response;
    }

    /***
    功能描述 : 更改花的属性
    * @author zlb
    * @date 2020/10/14
    * @param [flower]
    * @return int
    */
    @RequestMapping("updateFlower")
    public int updateFlower(Flower flower){
        System.out.println(flower);
        return flowerService.updateFlower(flower);
    }

    /***
    功能描述 :根据id删除商品
    * @author zlb
    * @date 2020/10/14
    * @param [flowerId]
    * @return int
    */
    @RequestMapping("deleteFlower")
    public int deleteFlower(int flowerId){
        return flowerService.deleteFlower(flowerId);
    }

    /***
    功能描述 :根据id查找商品
    * @author zlb
    * @date 2020/11/16
    * @param [flowerId]
    * @return com.zlb.flower_shop.bean.Flower
    */
    @RequestMapping("selectFlower")
    public Flower selectFlower(Integer flowerId){
        return flowerService.selectFlower(flowerId);
    }

}
