package com.excelr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value=NoDataFoundException.class)
	public ResponseEntity<ExceptionInfo> handleException(NoDataFoundException ae){
		ExceptionInfo e1=new ExceptionInfo();
		e1.setMsg(ae.getMessage());
		e1.setCode("Bhtyt678n");
		
		return new ResponseEntity<ExceptionInfo>(e1,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
}
