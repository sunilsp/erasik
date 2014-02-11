package com.rasik.exceptions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalControllerExceptionHandler {

	protected Logger logger;

	public GlobalControllerExceptionHandler() {
		logger = LoggerFactory.getLogger(getClass());
	}
	
	@ExceptionHandler(Throwable.class)
	  public String handleAnyException(Throwable ex, HttpServletRequest request) {
	    return "html/error/exceptionHandler";
	  }	

	// Convert a predefined exception to an HTTP Status code
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Page not found")
	// 409
	//@ExceptionHandler(DataIntegrityViolationException.class)
	public void conflict() {
		logger.error("Request raised a DataIntegrityViolationException");
		// Nothing to do
	}

	// Specify the name of a specific view that will be used to display the
	// error:
	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public String databaseError(Exception exception) {
		// Nothing to do. Return value 'databaseError' used as logical view name
		// of an error page, passed to view-resolver(s) in usual way.
		logger.error("Request raised " + exception.getClass().getSimpleName());
		return "databaseError";
	}

	// Total control - setup a model and return the view name
/*	@ExceptionHandler(CustomException.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception)
			throws Exception {

		// Rethrow annotated exceptions or they will be processed here instead.
		if (AnnotationUtils.findAnnotation(exception.getClass(),
				ResponseStatus.class) != null)
			throw exception;

		logger.error("Request: " + req.getRequestURI() + " raised " + exception);

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.addObject("timestamp", new Date());
		mav.addObject("status", 500);

		mav.setViewName("support");
		return mav;
	}
*/
	}