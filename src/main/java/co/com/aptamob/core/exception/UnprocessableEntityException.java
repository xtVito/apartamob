package co.com.aptamob.core.exception;

import java.util.List;

import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.exception.BaseWebApplicationException;

public class UnprocessableEntityException extends BaseWebApplicationException {

	public UnprocessableEntityException(List<ValidationError> validations, String... data) {
		super(422, "42202", "El registro de " + data[0] + " contiene errores", "Errores de validación en " + data[0], validations);
	}

}
