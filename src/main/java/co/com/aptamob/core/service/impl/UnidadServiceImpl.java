package co.com.aptamob.core.service.impl;

import java.util.ArrayList;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.aptamob.core.api.UnidadApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.bo.Unidad;
import co.com.aptamob.core.exception.DataDuplicateException;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.repository.*;
import co.com.aptamob.core.service.IUnidadService;

@Service("unidadService")
public class UnidadServiceImpl extends BaseService implements IUnidadService {
	
	private IUnidadRepository unidadR;

	public UnidadServiceImpl(Validator validator) {
		super(validator);
	}
	
	@Autowired
	public UnidadServiceImpl(IUnidadRepository repository, 
			Validator validator){
		this(validator);
        this.unidadR = repository;
	}
	
	private static final Logger LOG = LoggerFactory.getLogger(UnidadServiceImpl.class);
	
	@Transactional
	public UnidadApi createUnidad(UnidadApi request){
		validate(request);
		validaCampos(request);
		
		Unidad uni = unidadR.findById(Long.parseLong(request.getId()));
		if(uni != null){
			throw new DataDuplicateException(getClassName(Unidad.class.getName()), getClassName(Unidad.class.getName()));
		}
		uni = new Unidad(request);
		unidadR.save(uni);
		
		return new UnidadApi(uni);
	}
	
	private void validaCampos(UnidadApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		notNull(request.getDireccion(), "Dirección");
		notNull(request.getLongitud(), "Longitud");
		notNull(request.getLatitud(), "Latitud");
		notNull(request.getZona().getId(), "Zona");
		notNull(request.getEstado().getId(), "Estado");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Departamento.class.getName()));
		}
	}
	
	@Autowired
	public void setUnidadR(IUnidadRepository unidadR) {
		this.unidadR = unidadR;
	}
}
