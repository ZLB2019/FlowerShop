package com.zlb.flower_shop.dto;

import com.zlb.flower_shop.bean.Flower;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer orderId;
    private String userEmail;
    private Integer number;
    private Integer flowerId;
    private String flowerName;
    private BigDecimal price;
    private Integer type;
    private String image;

    public OrderDto(Flower flower){
        this.price=flower.getPrice();
        this.flowerId=flower.getFlowerId();
        this.flowerName=flower.getFlowerName();
        this.image=flower.getImage();
    }
}
