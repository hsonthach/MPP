package business;

import java.io.Serializable;

public class CheckoutException extends Exception implements Serializable {
	private static final long serialVersionUID = -4509348637887270880L;
	
	public CheckoutException() {
		super();
	}
	
	public CheckoutException(String message) {
		super(message);
	}
	
	public CheckoutException(Throwable t) {
		super(t);
	}
}
