package co.com.aptamob.core.service.impl;

import java.util.ArrayList;

import javax.validation.Validator;

import co.com.aptamob.core.api.PropiedadApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.service.IPropiedadService;

public class PropiedadServiceImpl extends BaseService implements IPropiedadService {

	public PropiedadServiceImpl(Validator validator) {
		super(validator);
	}
	
	private void validaCampos(PropiedadApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		notNull(request.getDescripcion(), "Descripción");
		notNull(request.getDetalle(), "Detalle");
		notNull(request.getCapacidad(), "Capacidad");
		notNull(request.getArea(), "Área");
		notNull(request.getTipo().getId(), "Tipo");
		notNull(request.getEstado().getId(), "Estado");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Departamento.class.getName()));
		}
	}

}
