/**
 * ErrorResponse.java
 * @author Vijay Chennam
 * Created on March 15, 2020
 */
package com.smitiv.student.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorResponse {

	private String message;

	private List<String> details;

	/**
	 * @param message
	 * @param details
	 */
	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return details
	 */
	public List<String> getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}
}