/*
 * Confidential and Proprietary.
 * Do not distribute without 1-800-Flowers.com, Inc. consent.
 * Copyright 1-800-Flowers.com, Inc. 2019. All rights reserved.
 */

package com.springboot.mongo.crud.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class SpringBootMongoCrudExceptionHandler {

    @ExceptionHandler(SpringBootMongoCrudException.class)
    public ResponseEntity<SpringBootMongoCrudErrorResponse> handleAddressServiceException(SpringBootMongoCrudException springBootMongoCrudException) {
    	
    	SpringBootMongoCrudErrorResponse springBootMongoCrudErrorResponse = buildAddressBookEntriesErrorResponse(springBootMongoCrudException);
    	log.info("SpringBootMongoCrudAPI springBootMongoCrudAPIException :" + springBootMongoCrudException.getMessage());
        return new ResponseEntity<>(springBootMongoCrudErrorResponse, springBootMongoCrudException.getHttpStatus());
    }

	private SpringBootMongoCrudErrorResponse buildAddressBookEntriesErrorResponse(SpringBootMongoCrudException springBootMongoCrudException) {
		
		SpringBootMongoCrudErrorResponse springBootMongoCrudErrorResponse = new SpringBootMongoCrudErrorResponse();
		
		ErrorObject errorObject = new ErrorObject();
		errorObject.setErrorMessage(springBootMongoCrudException.getMessage());
		
		ErrorState errorState = new ErrorState();
		errorState.setMessage(springBootMongoCrudException.getMessage());
		errorObject.setErrorState(errorState);
		
		springBootMongoCrudErrorResponse.setErrorObject(errorObject);
		springBootMongoCrudErrorResponse.setStatusCode(springBootMongoCrudException.getHttpStatus().value());
		
		return springBootMongoCrudErrorResponse;
	}

}
