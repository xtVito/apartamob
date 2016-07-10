package co.com.aptamob.core.service.impl;

import java.util.ArrayList;

import javax.validation.Validator;

import co.com.aptamob.core.api.ServicioApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.service.IServicioService;

public class ServicioServiceImpl extends BaseService implements IServicioService {

	public ServicioServiceImpl(Validator validator) {
		super(validator);
	}
	
	private void validaCampos(ServicioApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		notNull(request.getEstado().getId(), "Estado");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Departamento.class.getName()));
		}
	}

}
