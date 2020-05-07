package com.pg.resumebuilder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResumeDetailsNotFoundException extends RuntimeException {

	public ResumeDetailsNotFoundException(String message) {
		super(message);
	}

}
