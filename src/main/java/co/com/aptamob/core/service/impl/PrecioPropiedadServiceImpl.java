package co.com.aptamob.core.service.impl;

import java.util.ArrayList;

import javax.validation.Validator;

import co.com.aptamob.core.api.PrecioPropiedadApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.service.IPrecioPropiedadService;

public class PrecioPropiedadServiceImpl extends BaseService implements IPrecioPropiedadService {

	public PrecioPropiedadServiceImpl(Validator validator) {
		super(validator);
	}
	
	private void validaCampos(PrecioPropiedadApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getFecha_inicio(), "Fecha Inicio");
		notNull(request.getFecha_fin(), "Fecha Fin");
		notNull(request.getDiario(), "Diario");
		notNull(request.getMensual(), "Mensual");
		notNull(request.getEstado().getId(), "Estado");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Departamento.class.getName()));
		}
	}

}
