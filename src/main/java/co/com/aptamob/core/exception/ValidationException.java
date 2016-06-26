package co.com.aptamob.core.exception;

import co.com.aptamob.core.base.api.ErrorResponse;
import co.com.aptamob.core.base.api.ValidationError;

import javax.validation.ConstraintViolation;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ValidationException extends WebApplicationException {

    private final int status = 400;
    private String errorMessage;
    private String developerMessage;
    private List<ValidationError> errors = new ArrayList<ValidationError>();

    public ValidationException() {
        errorMessage = "Error de validación";
        developerMessage = "Los datos enviados no son válidos";
    }

    public ValidationException(String message) {
        super();
        errorMessage = message;
    }

    public ValidationException(Set<? extends ConstraintViolation<?>> violations) {
        this();
        for(ConstraintViolation<?> constraintViolation : violations) {
            ValidationError error = new ValidationError();
            error.setMessage(constraintViolation.getMessage());
            error.setPropertyName(constraintViolation.getPropertyPath().toString());
            error.setPropertyValue(constraintViolation.getInvalidValue() != null ? constraintViolation.getInvalidValue().toString() : null);
            errors.add(error);
        }
    }

    @Override
    public Response getResponse() {
        return Response.status(status).type(MediaType.APPLICATION_JSON_TYPE).entity(getErrorResponse()).build();
    }

    public ErrorResponse getErrorResponse() {
        ErrorResponse response = new ErrorResponse();
        response.setApplicationMessage(developerMessage);
        response.setConsumerMessage(errorMessage);
        response.setValidationErrors(errors);
        return response;
    }

}
