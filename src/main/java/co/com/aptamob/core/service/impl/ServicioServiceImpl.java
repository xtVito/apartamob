package co.com.aptamob.core.service.impl;

import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.*;
import co.com.aptamob.core.api.ServicioApi;
import co.com.aptamob.core.bo.Servicio;
import co.com.aptamob.core.exception.DataDuplicateException;
import co.com.aptamob.core.exception.DataNotFoundException;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.repository.IServicioRepository;
import co.com.aptamob.core.service.IServicioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

@Service("servicioService")
public class ServicioServiceImpl extends BaseService implements IServicioService {

	private IServicioRepository servicioR;
	
	public ServicioServiceImpl(Validator validator) {
        super(validator);
    }
	
	@Autowired
	public ServicioServiceImpl(IServicioRepository repository, 
			Validator validator) {
        this(validator);
        this.servicioR = repository;
    }
	
	private static final Logger LOG = LoggerFactory.getLogger(ServicioServiceImpl.class);
	
	@Transactional
	public ServicioApi createServicio(ServicioApi request){
		validate(request);
		validaCampos(request);
        
        Servicio ser = servicioR.findByNombre(request.getNombre());
        if(ser != null){
        	throw new DataDuplicateException(getClassName(Servicio.class.getName()), getClassName(Servicio.class.getName()));
        }
        
        ser = new Servicio(request);
        servicioR.save(ser);
        
        return new ServicioApi(ser);
	}
	
	
	@Transactional
	public ServicioApi saveServicio(ServicioApi servicioRequest, String codigo){
		validate(servicioRequest);
		
		Servicio ser = cargaServicio(codigo);
		
		if(servicioRequest.getNombre() != null){
			ser.setNombre(servicioRequest.getNombre());
		}
		
		servicioR.save(ser);
		
		return new ServicioApi(ser);
	}
	
	@Transactional
	public ServicioApi getServicio(String codigo){
        Assert.notNull(codigo);
        
        Servicio ser = cargaServicio(codigo);
        
        return new ServicioApi(ser);
	}
	
	
	@Transactional
	public List<ServicioApi> getServicios(){
		List<ServicioApi> apis = new ArrayList<ServicioApi> ();
		
		List<Servicio> sers = servicioR.findAll();
		if(sers == null || sers.size() == 0){
			throw new DataNotFoundException(getClassName(Servicio.class.getName()));
		}
		
		for(Servicio ser : sers){
			apis.add(new ServicioApi(ser));
		}
		
		return apis;
	}
	
	@Transactional
	public List<ServicioApi> getServicios(String nombre){
		Assert.notNull(nombre);
		List<ServicioApi> apis = new ArrayList<ServicioApi> ();
		
		List<Servicio> sers = servicioR.findByNombreIgnoreCaseContaining(nombre);
		if(sers == null || sers.size() == 0){
			throw new DataNotFoundException(getClassName(Servicio.class.getName()));
		}
		
		for(Servicio ser : sers){
			apis.add(new ServicioApi(ser));
		}
		
		return apis;
	}
	
	@Transactional
	public void deleteServicio(ServicioApi servicioRequest, String codigo){
		Assert.notNull(servicioRequest);
        Assert.notNull(codigo);
        
        Servicio ser = cargaServicio(codigo);
        
        //if (userMakingRequest.getRole().equalsIgnoreCase(Role.administrator.toString()) && (userToDelete.hasRole(Role.anonymous) || userToDelete.hasRole(Role.authenticated))) {
        	servicioR.delete(ser);
        /*} else {
            throw new AuthorizationException("User cannot be deleted. Only users with anonymous or authenticated role can be deleted.");
        }*/
	}
	
	
	
	private Servicio cargaServicio(String identificador){
		Servicio ser = null;
		ser = servicioR.findById(Long.parseLong(identificador));
		
		if(ser == null){
			throw new DataNotFoundException(getClassName(Servicio.class.getName()));
		}
		
		return ser;
	}
	
	
	private void validaCampos(ServicioApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Servicio.class.getName()));
		}
	}
	
	
	@Autowired
	public void setServicioR(IServicioRepository servicioR) {
		this.servicioR = servicioR;
	}
	
}
