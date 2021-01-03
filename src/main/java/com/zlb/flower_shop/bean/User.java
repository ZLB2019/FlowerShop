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
 用户实体类
 */
public class User{
    @TableId(type = IdType.AUTO)
    private Integer userId;         //用户id
    private String userPassword;    //用户密码
    private String userEmail;       //用户邮箱
}
