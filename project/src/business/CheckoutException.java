package business;

import java.io.Serializable;

public class CheckoutException extends Exception implements Serializable {
	private static final long serialVersionUID = -4509348637887270880L;
	
	private String fieldName = null;
	
	public CheckoutException() {
		super();
	}
	
	public CheckoutException(String message) {
		super(message);
	}
	
	public CheckoutException(String fieldName, String message) {
		this(message);
		this.fieldName = fieldName;
	}
	
	public CheckoutException(Throwable t) {
		super(t);
	}
	
	public String getFieldName() {
		return fieldName;
	}
}
