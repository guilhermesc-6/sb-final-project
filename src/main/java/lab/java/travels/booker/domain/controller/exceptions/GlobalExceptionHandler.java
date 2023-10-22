package lab.java.travels.booker.domain.controller.exceptions;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException){
		return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException){
		return new ResponseEntity<>("Resource ID not found",HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleUnexpectecException(Throwable unexpectecException){
		var message = "Resource ID not found";
		logger.error(message,unexpectecException);
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
}