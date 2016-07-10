package co.com.aptamob.core.service.impl;

import java.util.ArrayList;

import javax.validation.Validator;

import co.com.aptamob.core.api.TipoPropiedadApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.service.ITipoPropiedadService;

public class TipoPropiedadServiceImpl extends BaseService implements ITipoPropiedadService {

	public TipoPropiedadServiceImpl(Validator validator) {
		super(validator);
	}
	
	private void validaCampos(TipoPropiedadApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		notNull(request.getEstado().getId(), "Estado");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Departamento.class.getName()));
		}
	}
	
}
