package com.boot.study.exception;

import java.io.Serializable;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.Setter;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ResponseBody
	@ExceptionHandler(value = { NullPointerException.class })
	public Res exception(NullPointerException exception) {
		Res res = new Res();
		res.setCode("001");
		res.setMsg("有空指針");

		return res;
	}

//	@ExceptionHandler(value = { NullPointerException.class })
//	public ModelAndView exception(NullPointerException exception) {
//		Res res = new Res();
//		res.setCode("001");
//		res.setMsg("有空指針");
//
//		return new ModelAndView("");
//	}

	@ResponseBody
	@ExceptionHandler(value = { Throwable.class })
	public Res exception(Throwable throwable) {
		Res res = new Res();
		res.setCode("500");
		res.setMsg("未知异常：" + throwable.getMessage());

		return res;
	}

	@Getter
	@Setter
	public static class Res implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3640012704565708944L;
		private String code;
		private String msg;
	}
}
