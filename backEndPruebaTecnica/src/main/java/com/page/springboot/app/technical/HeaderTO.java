/**
 * 
 */
package com.page.springboot.app.technical;

import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpStatus;


public class HeaderTO {

	private int status;
	private String message;
	private Date timestamp;
	private String trace_exception;

	public HeaderTO() {

	}

	public HeaderTO(int httpStatus, String message, String exception) {
		this.status = httpStatus;
		this.message = message;
		this.timestamp = Calendar.getInstance().getTime();
		this.trace_exception = exception;
	}

	public HeaderTO(HttpStatus httpStatus, String message) {
		this.status = httpStatus.value();
		this.message = message;
		this.timestamp = Calendar.getInstance().getTime();
	}

	public HeaderTO(HttpStatus httpStatus, String message, String exception) {
		this.status = httpStatus.value();
		this.message = message;
		this.timestamp = Calendar.getInstance().getTime();
		this.trace_exception = exception;
	}

	public HeaderTO(HttpStatus httpStatus, String message, Exception exception) {
		this.status = httpStatus.value();
		this.message = message;
		this.timestamp = Calendar.getInstance().getTime();
		this.trace_exception = iterateStackTrace(exception).toString();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getTrace_exception() {
		return trace_exception;
	}

	public void setTrace_exception(String trace_exception) {
		this.trace_exception = trace_exception;
	}

	private StringBuilder iterateStackTrace(Throwable throwable) {
		StringBuilder builder = new StringBuilder();
		while (throwable != null) {
			builder.append("=>{" + throwable.getMessage() + "}").append("\n");
			throwable = throwable.getCause();
		}
		return builder;
	}
}
