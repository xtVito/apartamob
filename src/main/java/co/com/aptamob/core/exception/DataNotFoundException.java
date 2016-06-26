package co.com.aptamob.core.exception;

import co.com.aptamob.core.base.exception.BaseWebApplicationException;

public class DataNotFoundException extends BaseWebApplicationException {
	
	public DataNotFoundException(String... data){
		super(404, "40402", data[0] + " no existe", "No fue posible encontrar " + data[0]);
	}
}
