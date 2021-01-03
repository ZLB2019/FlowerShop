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
 管理员实体类
 */
public class Administrator {
    @TableId(type = IdType.AUTO)
    private Integer administratorId;        //管理员id
    private String administratorAccount;    //管理员账号
    private String administratorPassword;   //管理员密码
}
