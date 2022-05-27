package io.tom.seckill.controller;

import io.tom.seckill.common.CommonResult;
import io.tom.seckill.entity.OrderEntity;
import io.tom.seckill.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description： TODO
 * @author: DXF
 * @date: 2022-05-25 10:18:10
 * @version: 1.0
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {


    static Lock lock = new ReentrantLock();

    @Autowired
    private OrderService orderService;

    @PostMapping("/lockOrder")
    public CommonResult lockOrder (@RequestBody OrderEntity entity) {
        log.info("itemId: {}", entity.getItemId());
//        synchronized (entity.getItemsId()) {
            String id = orderService.lockOrder(entity);
            return new CommonResult(200, id);
//        }
    }

    @PostMapping("/lockOrderNormal")
    public CommonResult lockOrderNormal (@RequestBody OrderEntity entity) {
        log.info("itemId: {}", entity.getItemId());
//        synchronized (entity.getItemsId()) {
        String id = orderService.lockOrderNormal(entity);
        return new CommonResult(200, id);
//        }
    }

}
