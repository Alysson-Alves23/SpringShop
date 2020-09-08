package curso.start.resource.exeptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import curso.start.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ExceptionsHandlers {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<?> objectNotFoundResponse( ObjectNotFoundException e,HttpServletRequest req){
		StandardException ep =new StandardException(HttpStatus.NOT_FOUND.value(),
				e.getMessage(), 
				System.currentTimeMillis());
		return new ResponseEntity<>(ep,HttpStatus.NOT_FOUND);
		
	} 
}
