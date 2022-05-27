package io.tom.seckill.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共响应参数
 *
 * @author: dxf
 * @date: 2021-01-11 21:30:48
 */
@Data
@AllArgsConstructor
public class CommonResult<T> {
    /**
     * 响应码
     * */
    private Integer code;
    /**
     * 响应信息
     * */
    private String message;
    /**
     * 数据
     * */
    private T data;

    public CommonResult () {
        this.code = 200;
        this.message = "成功";
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
