package com.cg.capbook.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.capbook.customresponse.CustomResponse;
import com.cg.capbook.exceptions.AccountNotFoundException;


@ControllerAdvice(basePackages= {"com.cg.capbook.controllers"})
public class CapBookExceptionAspect {
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<CustomResponse>handleAccountNotFoundException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),e.getMessage());
		System.out.println(response);
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	
}
}
