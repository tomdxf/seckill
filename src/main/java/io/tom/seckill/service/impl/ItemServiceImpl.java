package io.tom.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.tom.seckill.dao.ItemDao;
import io.tom.seckill.entity.ItemEntity;
import io.tom.seckill.service.ItemService;
import org.springframework.stereotype.Service;

/**
 * @description： TODO
 * @author: DXF
 * @date: 2022-05-26 13:29:19
 * @version: 1.0
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemDao, ItemEntity> implements ItemService {
    @Override
    public void delItemNum(String id) {
        this.baseMapper.delItemNum(id);
    }

    @Override
    public Boolean delByMysqlLock(String itemId) {
        return this.baseMapper.delByMysqlLock(itemId);
    }
}
