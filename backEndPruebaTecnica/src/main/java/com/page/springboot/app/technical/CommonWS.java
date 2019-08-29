package com.page.springboot.app.technical;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

public abstract class CommonWS implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected ResponseTO<?> buildResponse(Object object) {
		ResponseTO<Object> response = new ResponseTO<>();
		HeaderTO header = null;
		if(object == null )
			header = new HeaderTO(HttpStatus.OK, "No hay informacion para mostrar.");
		else {
			boolean isEmpty = false;
			if(object instanceof Map)
				isEmpty = ((Map<?, ?>)object).isEmpty();
			if(object instanceof List)
				isEmpty = ((List<?>)object).isEmpty();
			if(isEmpty)
				header = new HeaderTO(HttpStatus.OK, "No hay informacion para mostrar.");
			else {
				header = new HeaderTO(HttpStatus.OK, "Solicitud procesada exitosamente.");
				response.setBody(object);
			}
		}		
		response.setHead(header);
		return response;
	}
}
