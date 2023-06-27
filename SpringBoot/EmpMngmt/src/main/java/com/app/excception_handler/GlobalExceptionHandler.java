package com.app.excception_handler;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;

//how to SC that following class is a spring bean---containing common advice to all rest controllers, 
//regarding centralized exc handling
@RestControllerAdvice //mandatory
//@RestControllerAdvice=@ControllerAdvice+@ResponseBody(added implicitely on rets type of methods)
//--we can use it in REST web services
public class GlobalExceptionHandler {
//can contain single/multiple exc handling methods
	//how to tell SC, folowing method: exc handling method
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
		
		//convert list --> map:field name, def msg
		Map<String, String> map=e.getFieldErrors()  //lis<FieldErr>
				.stream()  //stream<FieldErr>
				.collect(Collectors.toMap(f -> f.getField(), f -> f.getDefaultMessage()));
				
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getFieldErrors());
		//
		
	}
	// add a exc handling method for ResourceNotFoundException 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException e){
				
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
	}
}
