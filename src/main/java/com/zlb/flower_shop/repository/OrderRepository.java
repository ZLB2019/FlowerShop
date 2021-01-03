package com.zlb.flower_shop.repository;

import com.zlb.flower_shop.bean.Orders;
import com.zlb.flower_shop.dto.OrderDto;

import java.util.List;

public interface OrderRepository {
    int insertOrder(Orders order);

    int deleteOrder(Integer orderId);

    List<OrderDto> selectOrderByUserId(String userEmail,Integer type,int fag);

    int updateOrder(Orders order);
}
