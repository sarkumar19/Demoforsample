package com.mypru.globalexceptionhandler;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final org.slf4j.Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(PruadviserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handlePruadvisernotfoundexception(PruadviserNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
   @ExceptionHandler(IllegalArgumentException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e)
   {
	   logger.error("the given url are not prpper please try again",e);
	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please check the  request and provide the valid request");
   }
}
