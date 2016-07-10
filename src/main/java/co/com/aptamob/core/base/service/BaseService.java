package co.com.aptamob.core.base.service;

import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.exception.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public abstract class BaseService {

    private Validator validator;
    protected List<ValidationError> validationErrors;

    public BaseService(Validator validator) {
        this.validator = validator;
        this.validationErrors = new ArrayList<ValidationError>();
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
    
    protected void notNull(String campo, String nombre){
    	if (campo == null || !StringUtils.hasText(campo)) {
    		validationErrors.add(error(campo, nombre, "El campo " + nombre + " es requerido; no puede estar vacío."));
		}
    }
    
    protected void notDate(String fecha, String nombre){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date fechaR = new Date();
		try {
			fechaR = formatter.parse(fecha);
		} catch (ParseException e) {
			validationErrors.add(error(fecha, nombre, "El campo " + nombre + " es incorrecto; no es una fecha válida."));
		}
    }
    
    protected void notNumber(String numero, String nombre){
    	try{
    		BigDecimal bd = new BigDecimal(numero);
    	} catch (Exception e) {
    		validationErrors.add(error(numero, nombre, "El campo " + nombre + " es incorrecto; no es un número válido."));
		}
    }
    
    private ValidationError error(String campo, String nombre, String mensaje){
    	ValidationError ve = new ValidationError();
		ve.setPropertyName(nombre);
		ve.setPropertyValue(campo);
		ve.setMessage(mensaje);
		
		return ve;
    }
}
