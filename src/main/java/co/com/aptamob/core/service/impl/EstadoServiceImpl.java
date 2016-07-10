package co.com.aptamob.core.service.impl;

import java.util.ArrayList;

import javax.validation.Validator;

import co.com.aptamob.core.api.EstadoApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.service.IEstadoService;

public class EstadoServiceImpl extends BaseService implements IEstadoService {

	public EstadoServiceImpl(Validator validator) {
		super(validator);
	}
	
	private void validaCampos(EstadoApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Departamento.class.getName()));
		}
	}

}
