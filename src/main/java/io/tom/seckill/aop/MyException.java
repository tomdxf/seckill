package io.tom.seckill.aop;


/**
 * 自定义异常
 *
 */
public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private int code;
	private String msg;

	public MyException(int code) {
		this.code = code;
		this.msg = "服务器异常！";
	}


	public MyException(String msg) {
		super(msg);
		this.code = 500;
		this.msg = msg;
	}

	public MyException(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}