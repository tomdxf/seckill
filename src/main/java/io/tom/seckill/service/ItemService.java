package io.tom.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.tom.seckill.entity.ItemEntity;

/**
 * @description： TODO
 * @author: DXF
 * @date: 2022-05-26 13:28:39
 * @version: 1.0
 */
public interface ItemService extends IService<ItemEntity> {

    void delItemNum(String itemId);


    Boolean delByMysqlLock(String itemId);
}
