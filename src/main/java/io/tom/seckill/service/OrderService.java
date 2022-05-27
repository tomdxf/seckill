package io.tom.seckill.service;

import io.tom.seckill.entity.OrderEntity;

/**
 * @description： 测试Service
 * @author: DXF
 * @date: 2022-05-25 10:18:25
 * @version: 1.0
 */
public interface OrderService {

    String lockOrder(OrderEntity entity);


    String lockOrderNormal(OrderEntity entity);
}
