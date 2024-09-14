package business;

import java.io.Serializable;

public class BusinessRuleException extends Exception implements Serializable {
	private static final long serialVersionUID = -4509348637887270880L;
	
	private String fieldName = null;
	
	public BusinessRuleException() {
		super();
	}
	
	public BusinessRuleException(String message) {
		super(message);
	}
	
	public BusinessRuleException(String fieldName, String message) {
		this(message);
		this.fieldName = fieldName;
	}
	
	public BusinessRuleException(Throwable t) {
		super(t);
	}
	
	public String getFieldName() {
		return fieldName;
	}
}
