package co.com.aptamob.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.aptamob.core.api.CiudadApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Ciudad;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.exception.DataDuplicateException;
import co.com.aptamob.core.exception.DataNotFoundException;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.repository.ICiudadRepository;
import co.com.aptamob.core.service.ICiudadService;

@Service("ciudadService")
public class CiudadServiceImpl extends BaseService implements ICiudadService{
	
	private ICiudadRepository ciudadR;
	
	public CiudadServiceImpl(Validator validator) {
        super(validator);
    }
	
	@Autowired
	public CiudadServiceImpl(ICiudadRepository repository, 
			Validator validator) {
        this(validator);
        this.ciudadR = repository;
    }

	private static final Logger LOG = LoggerFactory.getLogger(CiudadServiceImpl.class);
	
	
	@Transactional
	public CiudadApi createCiudad(CiudadApi request, String id){
		validate(request);
		validaCampos(request);
        
		Ciudad ciu = ciudadR.findByNombre(request.getNombre());
        if(ciu != null){
        	throw new DataDuplicateException(getClassName(Ciudad.class.getName()), getClassName(Ciudad.class.getName()));
        }
        ciu = new Ciudad(request);
        
        Departamento dep = new Departamento();
        dep.setId(Long.parseLong(id));        
        ciu.setDepartamento(dep);
        ciudadR.save(ciu);
        
        return new CiudadApi(ciu);
	}
	
	
	@Transactional
	public CiudadApi saveCiudad(CiudadApi request, String codigo){
		validate(request);
		notNull(codigo, "Id de la ciudad");
		validaCampos(request);
		
		Ciudad ciu = cargaCiudad(codigo);
		
		if(request.getNombre() != null){
			ciu.setNombre(request.getNombre());
		}
		
		ciudadR.save(ciu);
		
		return new CiudadApi(ciu);
	}
	
	
	@Transactional
	public CiudadApi getCiudad(String codigo){
		notNull(codigo, "Id de la ciudad");
        
		Ciudad ciu = cargaCiudad(codigo);
        
        return new CiudadApi(ciu);
	}
	
	
	@Transactional
	public List<CiudadApi> getCiudades(){
		List<CiudadApi> apis = new ArrayList<CiudadApi> ();
		
		List<Ciudad> cius = ciudadR.findAll();
		if(cius == null || cius.size() == 0){
			throw new DataNotFoundException(getClassName(Ciudad.class.getName()));
		}
		
		for(Ciudad ciu : cius){
			apis.add(new CiudadApi(ciu));
		}
		
		return apis;
	}
	
	
	@Transactional
	public List<CiudadApi> getCiudades(String nombre){
		notNull(nombre, "Nombre de la ciudad");
		List<CiudadApi> apis = new ArrayList<CiudadApi> ();
		
		List<Ciudad> cius = ciudadR.findByNombreIgnoreCaseContaining(nombre);
		if(cius == null || cius.size() == 0){
			throw new DataNotFoundException(getClassName(Ciudad.class.getName()));
		}
		
		for(Ciudad ciu : cius){
			apis.add(new CiudadApi(ciu));
		}
		
		return apis;
	}
	
	
	private Ciudad cargaCiudad(String identificador){
		Ciudad ciu = null;
		ciu = ciudadR.findById(Long.parseLong(identificador));
		
		if(ciu == null){
			throw new DataNotFoundException(getClassName(Ciudad.class.getName()));
		}
		
		return ciu;
	}
	
	private void validaCampos(CiudadApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Ciudad.class.getName()));
		}
	}
	
	@Autowired
	public void setCiudadR(ICiudadRepository ciudadR) {
		this.ciudadR = ciudadR;
	}
}
