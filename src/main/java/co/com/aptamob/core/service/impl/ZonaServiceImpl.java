package co.com.aptamob.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.aptamob.core.api.ZonaApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.bo.Zona;
import co.com.aptamob.core.exception.DataDuplicateException;
import co.com.aptamob.core.exception.DataNotFoundException;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.repository.IZonaRepository;
import co.com.aptamob.core.service.IZonaService;

@Service("zonaService")
public class ZonaServiceImpl extends BaseService implements IZonaService {
	
private IZonaRepository zonaR;
	
	public ZonaServiceImpl(Validator validator) {
        super(validator);
    }
	
	@Autowired
	public ZonaServiceImpl(IZonaRepository repository, 
			Validator validator) {
        this(validator);
        this.zonaR = repository;
    }
	
	private static final Logger LOG = LoggerFactory.getLogger(ZonaServiceImpl.class);

	@Transactional
	public ZonaApi createZona(ZonaApi request, String id){
		validate(request);
		validaCampos(request);
        
        Zona zon = zonaR.findByNombre(request.getNombre());
        if(zon != null){
        	throw new DataDuplicateException(getClassName(Zona.class.getName()), getClassName(Zona.class.getName()));
        }
        zon = new Zona(request);
        
        Departamento dep = new Departamento();
        dep.setId(Long.parseLong(id));
        zon.setDepartamento(dep);
        zonaR.save(zon);
        
        return new ZonaApi(zon);
	}

	@Transactional
	public ZonaApi saveZona(ZonaApi request, String codigo){
		validate(request);
		notNull(codigo, "Id de la zona");
		validaCampos(request);
		
		Zona zon = cargaZona(codigo);
		
		if(request.getNombre() != null){
			zon.setNombre(request.getNombre());
		}
		
		zonaR.save(zon);
		
		return new ZonaApi(zon);
	}
	
	
	@Transactional
	public ZonaApi getZona(String codigo){
		notNull(codigo, "Id de la zona");
        
        Zona zon = cargaZona(codigo);
        
        return new ZonaApi(zon);
	}
	
	@Transactional
	public List<ZonaApi> getZonas(){
		List<ZonaApi> apis = new ArrayList<ZonaApi> ();
		
		List<Zona> zons = zonaR.findAll();
		if(zons == null || zons.size() == 0){
			throw new DataNotFoundException(getClassName(Zona.class.getName()));
		}
		
		for(Zona zon : zons){
			apis.add(new ZonaApi(zon));
		}
		
		return apis;
	}
	
	@Transactional
	public List<ZonaApi> getZonas(String nombre){
		notNull(nombre, "Nombre de la zona");
		List<ZonaApi> apis = new ArrayList<ZonaApi> ();
		
		List<Zona> zons = zonaR.findByNombreIgnoreCaseContaining(nombre);
		if(zons == null || zons.size() == 0){
			throw new DataNotFoundException(getClassName(Zona.class.getName()));
		}
		
		for(Zona zon : zons){
			apis.add(new ZonaApi(zon));
		}
		
		return apis;
	}
	
	@Transactional
	public void deleteZona(String codigo){
		//Assert.notNull(zonaRequest);
		notNull(codigo, "Id de la zona");
        
        Zona zon = cargaZona(codigo);
        
        //if (userMakingRequest.getRole().equalsIgnoreCase(Role.administrator.toString()) && (userToDelete.hasRole(Role.anonymous) || userToDelete.hasRole(Role.authenticated))) {
        	zonaR.delete(zon);
        /*} else {
            throw new AuthorizationException("User cannot be deleted. Only users with anonymous or authenticated role can be deleted.");
        }*/
	}
	
	
	private Zona cargaZona(String identificador){
		Zona zon = null;
		zon = zonaR.findById(Long.parseLong(identificador));
		
		if(zon == null){
			throw new DataNotFoundException(getClassName(Zona.class.getName()));
		}
		
		return zon;
	}
	
	private void validaCampos(ZonaApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Zona.class.getName()));
		}
	}
	
	@Autowired
	public void setZonaR(IZonaRepository zonaR) {
		this.zonaR = zonaR;
	}

	
}
