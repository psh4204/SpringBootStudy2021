package com.example.study.repository;


import com.example.study.model.entity.OrderDetail;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOderAt(LocalDateTime.now());

        // 어떤 사람?
        orderDetail.setUserId(9L);

        // 어떤 상품
        orderDetail.setItemId(9L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);

    }
}
