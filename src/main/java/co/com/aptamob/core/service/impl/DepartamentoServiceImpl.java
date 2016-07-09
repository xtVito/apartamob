package co.com.aptamob.core.service.impl;

import co.com.aptamob.security.config.ApplicationConfig;
import co.com.aptamob.core.base.service.*;
import co.com.aptamob.core.api.DepartamentoApi;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.exception.DataDuplicateException;
import co.com.aptamob.core.exception.DataNotFoundException;
import co.com.aptamob.core.repository.IDepartamentoRepository;
import co.com.aptamob.core.service.IDepartamentoService;
import co.com.aptamob.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.Validator;

import java.util.ArrayList;
import java.util.List;

@Service("departamentoService")
public class DepartamentoServiceImpl extends BaseService implements IDepartamentoService{
	
	private IDepartamentoRepository departamentoR;
	
	public DepartamentoServiceImpl(Validator validator) {
        super(validator);
    }
	
	@Autowired
	public DepartamentoServiceImpl(IDepartamentoRepository repository, 
			Validator validator) {
        this(validator);
        this.departamentoR = repository;
    }
	
	private static final Logger LOG = LoggerFactory.getLogger(DepartamentoServiceImpl.class);
	
	@Transactional
	public DepartamentoApi createDepartamento(DepartamentoApi request){
		validate(request);
        
        Departamento dep = departamentoR.findByNombre(request.getNombre());
        if(dep != null){
        	throw new DataDuplicateException(getClassName(Departamento.class.getName()), getClassName(Departamento.class.getName()));
        }
        dep = new Departamento(request);
        departamentoR.save(dep);
        
        return new DepartamentoApi(dep);
	}
	
	@Transactional
	public DepartamentoApi saveDepartamento(DepartamentoApi request, String codigo){
		validate(request);
		
		Departamento dep = cargaDepartamento(codigo);
		
		if(request.getNombre() != null){
			dep.setNombre(request.getNombre());
		}
		
		departamentoR.save(dep);
		
		return new DepartamentoApi(dep);
	}
	
	@Transactional
	public DepartamentoApi getDepartamento(String codigo){
        Assert.notNull(codigo);
        
        Departamento dep = cargaDepartamento(codigo);
        
        return new DepartamentoApi(dep);
	}
	
	@Transactional
	public List<DepartamentoApi> getDepartamentos(){
		List<DepartamentoApi> apis = new ArrayList<DepartamentoApi> ();
		
		List<Departamento> deps = departamentoR.findAll();
		if(deps == null || deps.size() == 0){
			throw new DataNotFoundException(getClassName(Departamento.class.getName()));
		}
		
		for(Departamento dep : deps){
			apis.add(new DepartamentoApi(dep));
		}
		
		return apis;
	}
	
	@Transactional
	public List<DepartamentoApi> getDepartamentos(String nombre){
		Assert.notNull(nombre);
		List<DepartamentoApi> apis = new ArrayList<DepartamentoApi> ();
		
		List<Departamento> deps = departamentoR.findByNombreIgnoreCaseContaining(nombre);
		if(deps == null || deps.size() == 0){
			throw new DataNotFoundException(getClassName(Departamento.class.getName()));
		}
		
		for(Departamento dep : deps){
			apis.add(new DepartamentoApi(dep));
		}
		
		return apis;
	}
	
	@Transactional
	public void deleteDepartamento(String codigo){
		//Assert.notNull(departamentoRequest);
        Assert.notNull(codigo);
        
        Departamento dep = cargaDepartamento(codigo);
        
        //if (userMakingRequest.getRole().equalsIgnoreCase(Role.administrator.toString()) && (userToDelete.hasRole(Role.anonymous) || userToDelete.hasRole(Role.authenticated))) {
        	departamentoR.delete(dep);
        /*} else {
            throw new AuthorizationException("User cannot be deleted. Only users with anonymous or authenticated role can be deleted.");
        }*/
	}
	
	private Departamento cargaDepartamento(String identificador){
		Departamento dep = null;
		dep = departamentoR.findById(Long.parseLong(identificador));
		
		if(dep == null){
			throw new DataNotFoundException(getClassName(Departamento.class.getName()));
		}
		
		return dep;
	}
	
	@Autowired
	public void setDepartamentoR(IDepartamentoRepository departamentoR) {
		this.departamentoR = departamentoR;
	}
}
