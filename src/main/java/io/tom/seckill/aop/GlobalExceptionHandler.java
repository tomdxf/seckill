package io.tom.seckill.aop;

import io.tom.seckill.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public CommonResult handle(Exception e) {
		e.printStackTrace();
		log.error(e.getLocalizedMessage());
		Integer code;
		String message;
		if (e instanceof MyException) {
			log.error("BusinessException异常处理，捕获异常信息:{}", e.getMessage());
			MyException myException = (MyException) e;
			code = myException.getCode();
			message = myException.getMessage();
		}  else {
			log.error("Exception异常处理，捕获异常信息:{}", e.getMessage());
			code = 500;
			message = e.getMessage();
		}

		return new CommonResult(code,message);
	}
}
