package com.suporte.helpdesk.recouces.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errorrs = new ArrayList<>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrorrs() {
		return errorrs;
	}

	public void addError(String fieldName, String message) {
		this.errorrs.add(new FieldMessage(fieldName, message));
	}
	
	

}
