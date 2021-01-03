package com.zlb.flower_shop.dto;

import com.zlb.flower_shop.bean.Flower;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Integer carId;
    private Integer number;
    private String flowerName;
    private Integer flowerId;
    private Integer userId;
    private BigDecimal price;
    private String image;

    public CarDto(Flower flower){
        this.flowerId=flower.getFlowerId();
        this.flowerName=flower.getFlowerName();
        this.image=flower.getImage();
        this.price=flower.getPrice();
    }
}
