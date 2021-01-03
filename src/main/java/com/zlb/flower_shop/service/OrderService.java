package com.zlb.flower_shop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlb.flower_shop.bean.Flower;
import com.zlb.flower_shop.bean.Orders;
import com.zlb.flower_shop.dto.OrderDto;
import com.zlb.flower_shop.mapper.FlowerMapper;
import com.zlb.flower_shop.mapper.OrderMapper;
import com.zlb.flower_shop.mapper.UserMapper;
import com.zlb.flower_shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderRepository {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    FlowerMapper flowerMapper;

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Override
    public int insertOrder(Orders order) {
        return orderMapper.insert(order);
    }

    @Override
    public int deleteOrder(Integer orderId) {
        return orderMapper.deleteById(orderId);
    }

    @Override
    public List<OrderDto> selectOrderByUserId(String userEmail,Integer type,int fag) {
        QueryWrapper<Orders> walletQueryWrapper = new QueryWrapper<>();
        if(fag!=0) {
            if(type==-1)
                walletQueryWrapper.eq("user_id",userService.selectUserByUser_email(userEmail).getUserId());
            else
                walletQueryWrapper.eq("type",type);
        }
        List<Orders> list= orderMapper.selectList(walletQueryWrapper);
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Orders order:list){
            Flower flower = flowerMapper.selectById(order.getFlowerId());
            OrderDto orderDto = new OrderDto(flower);
            orderDto.setUserEmail(userMapper.selectById(order.getUserId()).getUserEmail());
            orderDto.setOrderId(order.getOrderId());
            orderDto.setType(order.getType());
            orderDto.setNumber(order.getNumber());
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    @Override
    public int updateOrder(Orders order) {
        return orderMapper.updateById(order);
    }
}
