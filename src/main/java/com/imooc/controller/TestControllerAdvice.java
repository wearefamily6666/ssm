package com.imooc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * 全局异常处理
 * @author Administrator
 *
 */
@ControllerAdvice
public class TestControllerAdvice {
/*	   @ExceptionHandler
	    public ModelAndView exceptionHandler(Exception ex){
	        ModelAndView mv = new ModelAndView("error");
	        mv.addObject("exception", ex);
	        System.out.println("in testControllerAdvice");
	        return mv;
	    }*/

}
