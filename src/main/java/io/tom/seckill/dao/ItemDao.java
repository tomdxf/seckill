package io.tom.seckill.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.tom.seckill.entity.ItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @description： TODO
 * @author: DXF
 * @date: 2022-05-26 13:30:21
 * @version: 1.0
 */
@Mapper
public interface ItemDao extends BaseMapper<ItemEntity> {
    @Update({"update item set num = num -1 where id = #{id}"})
    void delItemNum(@Param("id") String id);
    @Update({"update item set num = num -1 where id = #{id} and num > 0"})
    Boolean delByMysqlLock(String itemId);
}
