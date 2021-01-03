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
 分类实体类
 */
public class Classification {
    @TableId(type = IdType.AUTO)
    private Integer classId;    //分类id
    private String className;   //分类名
}
