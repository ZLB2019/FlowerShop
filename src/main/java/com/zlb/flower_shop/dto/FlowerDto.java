package com.zlb.flower_shop.dto;

import com.zlb.flower_shop.bean.Flower;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
功能描述 : 描叙花具体的信息
* @author zlb
* @date 2020/9/29
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowerDto {
    private Integer flowerId;
    private String flowerName;
    private Integer number;
    private Integer classId;
    private Integer vendorId;
    private BigDecimal price;
    private String className;
    private String vendorName;
    private String image;

    public FlowerDto(Flower flower){
        this.flowerId=flower.getFlowerId();
        this.classId=flower.getClassId();
        this.flowerName=flower.getFlowerName();
        this.number=flower.getNumber();
        this.vendorId=flower.getVendorId();
        this.price=flower.getPrice();
        this.image=flower.getImage();
    }
}
