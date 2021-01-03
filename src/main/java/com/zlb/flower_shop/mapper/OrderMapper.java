package com.zlb.flower_shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlb.flower_shop.bean.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
