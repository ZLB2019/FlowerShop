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
 厂商实体类
 */
public class Vendor {
    @TableId(type = IdType.AUTO)
    private Integer vendorId;       //厂商id
    private String vendorName;      //厂商名
}
