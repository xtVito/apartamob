package co.com.aptamob.core.exception;

import co.com.aptamob.core.base.exception.BaseWebApplicationException;

public class DataDuplicateException extends BaseWebApplicationException {
	
	public DataDuplicateException(String... data){
		super(409, "40901", data[0] + " ya existe", "Se intentó crear " + data[1] + " que ya existe");
	}
}
