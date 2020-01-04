package com.real.athletic.index.exception.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BusinessException logic and business related exception will be invoked
 * 
 * @author Aathitya Prabu A S
 *
 */
@ResponseStatus(HttpStatus.OK)
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 7626368018243014192L;

	public BusinessException(String exception) {
		super(exception);
	}
}
