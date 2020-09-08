package curso.start.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	public ObjectNotFoundException(String msg, Throwable c) {
		super(msg, c);
	}
}
