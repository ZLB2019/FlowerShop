package com.zlb.flower_shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 购物车实体类
 */
public class Car {
    @TableId(type = IdType.AUTO)
    private Integer carId;      //购物车id
    private Integer flowerId;   //商品id
    private Integer number;     //商品数量
    private Integer userId;     //用户id
}
