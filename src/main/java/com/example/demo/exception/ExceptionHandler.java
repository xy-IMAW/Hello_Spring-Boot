/**
 * 
 */
package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.entity.ExceptionResultEntity;
import com.example.demo.utils.ExceptionUtils;

/**
 * 
 *
 */
@RestControllerAdvice(annotations = RestController.class)
@ResponseBody
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler
	@ResponseStatus
	public ExceptionResultEntity runtimeExceptionHandler(Exception e) {
		return ExceptionUtils.error(e.getMessage(),e);
	}
	
}
