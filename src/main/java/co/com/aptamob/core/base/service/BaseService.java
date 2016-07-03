package co.com.aptamob.core.base.service;

import co.com.aptamob.core.exception.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public abstract class BaseService {

    private Validator validator;

    public BaseService(Validator validator) {
        this.validator = validator;
    }

    protected void validate(Object request) {
        Set<? extends ConstraintViolation<?>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() > 0) {
            throw new ValidationException(constraintViolations);
        }
    }
    
    protected String getClassName(String entidad){
    	String[] clase = entidad.split("\\.");
		return clase[clase.length-1].toLowerCase();
    }
}
