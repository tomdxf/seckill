package io.tom.seckill.service.impl;

import io.tom.seckill.aop.MyException;
import io.tom.seckill.entity.ItemEntity;
import io.tom.seckill.entity.OrderEntity;
import io.tom.seckill.service.ItemService;
import io.tom.seckill.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @description： impl
 * @author: DXF
 * @date: 2022-05-25 10:19:48
 * @version: 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private static List<String> itemList = new ArrayList<>();

    @Resource
    private ItemService itemService;

    private static Integer count = 10;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String lockOrder(OrderEntity entity) {

        // insert商品表
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(Long.valueOf(++count));
        itemEntity.setNum(-1);
        itemService.save(itemEntity);
        Boolean row = itemService.delByMysqlLock(entity.getItemId());
        if (!row) {
            throw new MyException("已无库存！");
        }

        // 发送短信

        return row + "";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String lockOrderNormal(OrderEntity entity) {
        ItemEntity byId = itemService.getById(entity.getItemId());
        if (byId.getNum() <= 0) {
            throw new MyException("已无库存！");
        }
        // 模拟业务耗时
        itemService.delItemNum(entity.getItemId());

        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
