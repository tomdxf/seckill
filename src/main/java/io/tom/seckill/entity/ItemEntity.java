package io.tom.seckill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description： 货物表
 * @author: DXF
 * @date: 2022-05-26 13:26:29
 * @version: 1.0
 */
@Data
@TableName("item")
public class ItemEntity {

    private Long id;

    private Integer num;
}
