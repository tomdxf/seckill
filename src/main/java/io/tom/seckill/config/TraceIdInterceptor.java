package io.tom.seckill.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @description： TODO
 * @author: DXF
 * @date: 2022-11-17 17:43:35
 * @version: 1.0
 */
@Component
@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor {
    private static final String UNIQUE_ID = "trace_id";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //log.info("进入 LogInterceptor");
        //添加MDC值
        MDC.put(UNIQUE_ID, UUID.randomUUID().toString().replace("-", ""));
        //打印接口请求信息
        String method = request.getMethod();
        String uri = request.getRequestURI();
        log.info("[请求接口] : {} : {}", method, uri);
        //打印请求参数
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //log.info("执行 LogInterceptor");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //log.info("退出 LogInterceptor");
        //打印请求结果
        //删除MDC值
        MDC.remove(UNIQUE_ID);
    }
}