package exceptions;

public class InvalidMovementException extends Exception {

	public InvalidMovementException() {
		super("Invalid movement, the position should be between (0,0) and (2,2)");
	}

}
