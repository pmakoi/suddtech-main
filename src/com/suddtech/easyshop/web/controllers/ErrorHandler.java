package com.suddtech.easyshop.web.controllers;


import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.suddtech.easyshop.dao.GenericDaoImpl;

@ControllerAdvice
public class ErrorHandler {
	private static Logger logger = Logger.getLogger(ErrorHandler.class);

	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseExceptionError(DataAccessException ex) {
		logger.error(ex);
		ex.printStackTrace();

		return "error";
	}

	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessExceptionError(AccessDeniedException ex) {
		ex.printStackTrace();
		logger.error(ex);

		return "denied";
	}
}
