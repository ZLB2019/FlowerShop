package com.zlb.flower_shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 商品实体类
 */
public class Flower {
    @TableId(type = IdType.AUTO)
    private Integer flowerId;   //商品id
    private String flowerName;  //商品名
    private Integer number;     //商品数量
    private Integer classId;    //分类id
    private Integer vendorId;   //厂商id
    private BigDecimal price;   //价格
    private String image;       //样图
}
