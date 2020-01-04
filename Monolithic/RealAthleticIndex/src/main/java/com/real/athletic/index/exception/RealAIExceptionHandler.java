package com.real.athletic.index.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.real.athletic.index.constant.RealAIConstants;
import com.real.athletic.index.exception.utils.BusinessException;
import com.real.athletic.index.utils.RealAIUtilService;
import com.real.athletic.index.utils.Response;

/**
 * RealAIExceptionHandler Global exception handling file
 * 
 * @author Aathitya Prabu A S
 *
 */
@ControllerAdvice
public class RealAIExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		logger.error(RealAIConstants.EXCEPTION, ex);
		Response response = new Response();
		response.setMessage(ex.getLocalizedMessage());
		Map<String, Object> dataResponse = RealAIUtilService.errorJson(HttpStatus.INTERNAL_SERVER_ERROR, false,
				response);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dataResponse);
	}

	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(BusinessException ex, WebRequest request) {
		logger.error(RealAIConstants.EXCEPTION, ex);
		Response response = new Response();
		response.setMessage(ex.getLocalizedMessage());
		Map<String, Object> dataResponse = RealAIUtilService.errorJson(HttpStatus.NOT_FOUND, true, response);
		return ResponseEntity.status(HttpStatus.OK).body(dataResponse);

	}
}
