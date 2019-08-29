/**
 * 
 */
package com.page.springboot.app.technical;

import java.io.Serializable;


public class ResponseTO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private HeaderTO head;
	private T body;

	public ResponseTO() {
	}

	public ResponseTO(HeaderTO headerTO) {
		this.head = headerTO;
	}

	public HeaderTO getHead() {
		return head;
	}

	public void setHead(HeaderTO head) {
		this.head = head;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

}
