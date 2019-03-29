package com.bnr.onlineShopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","The page is not constructed");
		mv.addObject("title","404 Error Page");
		mv.addObject("errorDescription","The page you're looking for is not available now!");
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Product not available");
		mv.addObject("title","404 Error Page");
		mv.addObject("errorDescription","The product is not available now!");
		return mv;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerGlobalException(Exception e) {
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Something went wrong check your request url");
		/***only for debugging***/
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		
		e.printStackTrace(pw);
		mv.addObject("title","404 Error Page");
		/**only for debug now change e to sw**/
		mv.addObject("errorDescription",sw.toString());
		return mv;
		
	}
}
