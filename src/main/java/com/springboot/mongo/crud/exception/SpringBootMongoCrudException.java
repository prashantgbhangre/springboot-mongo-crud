/*
 * Confidential and Proprietary.
 * Do not distribute without 1-800-Flowers.com, Inc. consent.
 * Copyright 1-800-Flowers.com, Inc. 2019. All rights reserved.
 */

package com.springboot.mongo.crud.exception;

import org.springframework.http.HttpStatus;

public class SpringBootMongoCrudException extends Exception {

    private static final long serialVersionUID = 1L;
    
    private HttpStatus httpStatus;
 
	public SpringBootMongoCrudException() {
        super();
    }

    public SpringBootMongoCrudException(String message) {
        super(message);
    }

    public SpringBootMongoCrudException(String message, HttpStatus httpStatus) {
        super(message);
        setHttpStatus(httpStatus);
    }
    
    public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}


    
}
