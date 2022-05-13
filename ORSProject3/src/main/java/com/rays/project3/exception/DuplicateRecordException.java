package com.rays.project3.exception;
/**
 * @author Pushpendra Singh Kushwah
 */
public class DuplicateRecordException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DuplicateRecordException(String msg) {
		super(msg);
	}
}
