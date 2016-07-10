package co.com.aptamob.core.service.impl;

import java.util.ArrayList;

import javax.validation.Validator;

import co.com.aptamob.core.api.CiudadApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.service.ICiudadService;

public class CiudadServiceImpl extends BaseService implements ICiudadService {

	public CiudadServiceImpl(Validator validator) {
		super(validator);
	}
	
	private void validaCampos(CiudadApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Departamento.class.getName()));
		}
	}

}
