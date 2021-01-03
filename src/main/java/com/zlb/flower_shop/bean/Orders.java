package com.zlb.flower_shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 订单实体类
 */
public class Orders {
    @TableId(type = IdType.AUTO)
    private Integer orderId;    //订单id
    private Integer flowerId;   //商品id
    private Integer number;     //商品数量
    private Integer userId;     //用户id
    private Integer type;       //订单状态
}
