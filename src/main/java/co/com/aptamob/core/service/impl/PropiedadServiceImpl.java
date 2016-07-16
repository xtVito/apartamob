package co.com.aptamob.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.aptamob.core.api.DepartamentoApi;
import co.com.aptamob.core.api.PropiedadApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.bo.Propiedad;
import co.com.aptamob.core.exception.DataNotFoundException;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.repository.IPropiedadRepository;
import co.com.aptamob.core.service.IPropiedadService;

@Service("propiedadService")
public class PropiedadServiceImpl extends BaseService implements IPropiedadService {
	
	private IPropiedadRepository propiedadR;

	public PropiedadServiceImpl(Validator validator) {
		super(validator);
	}
	
	@Autowired
	public PropiedadServiceImpl(IPropiedadRepository repository,
			Validator validator) {
		this(validator);
		this.propiedadR = repository;
	}
	
	private static final Logger LOG = LoggerFactory.getLogger(PropiedadServiceImpl.class);
	
	@Transactional
	public List<PropiedadApi> getPropiedades(PropiedadApi request){
		List<PropiedadApi> apis = new ArrayList<PropiedadApi>();
		
		List<Propiedad> props = propiedadR.findAllCustom(request.getFiltro());
		if(props == null || props.size() == 0){
			throw new DataNotFoundException(getClassName(Propiedad.class.getName()));
		}
		
		for(Propiedad prop : props){
			apis.add(new PropiedadApi(prop));
		}
		
		return apis;
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
	
	@Autowired
	public void setPropiedadR(IPropiedadRepository propiedadR) {
		this.propiedadR = propiedadR;
	}

}
