package co.com.aptamob.core.service.impl;

import co.com.aptamob.core.base.service.*;
import co.com.aptamob.core.api.TablaApi;
import co.com.aptamob.core.bo.Tabla;
import co.com.aptamob.core.exception.DataNotFoundException;
import co.com.aptamob.core.repository.ITablaRepository;
import co.com.aptamob.core.service.ITablaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.Validator;

import java.util.ArrayList;
import java.util.List;

@Service("tablaService")
public class TablaServiceImpl extends BaseService implements ITablaService {
	
	private ITablaRepository tablaR;
	
	public TablaServiceImpl(Validator validator) {
        super(validator);
    }
	
	@Autowired
	public TablaServiceImpl(ITablaRepository repository, 
			Validator validator) {
        this(validator);
        this.tablaR = repository;
    }
	
	private static final Logger LOG = LoggerFactory.getLogger(TablaServiceImpl.class);
	
	/*
	@Transactional
	public TablaApi getTabla(String codigo){
        Assert.notNull(codigo);
        
        Tabla tab = cargaTabla(codigo);
        
        return new TablaApi(tab);
	}*/
	
	
	@Transactional
	public TablaApi getTabla(String nombre){
        Assert.notNull(nombre);
        
        Tabla tab = cargaTabla(nombre);
        
        return new TablaApi(tab);
	}
	
	
	@Transactional
	public List<TablaApi> getTablas(){
		List<TablaApi> apis = new ArrayList<TablaApi> ();
		
		List<Tabla> tabs = tablaR.findAll();
		if(tabs == null || tabs.size() == 0){
			throw new DataNotFoundException(getClassName(Tabla.class.getName()));
		}
		
		for(Tabla tab : tabs){
			apis.add(new TablaApi(tab));
		}
		
		return apis;
	}
	
	
	@Transactional
	public List<TablaApi> getTablas(String nombre){
		Assert.notNull(nombre);
		List<TablaApi> apis = new ArrayList<TablaApi> ();
		
		List<Tabla> tabs = tablaR.findByNombreIgnoreCaseContaining(nombre);
		if(tabs == null || tabs.size() == 0){
			throw new DataNotFoundException(getClassName(Tabla.class.getName()));
		}
		
		for(Tabla tab : tabs){
			apis.add(new TablaApi(tab));
		}
		
		return apis;
	}
	
	
	private Tabla cargaTabla(String nombre){
		Tabla tab = null;
		//tab = tablaR.findById(Long.parseLong(identificador));
		tab = tablaR.findByNombre(nombre);
		
		if(tab == null){
			throw new DataNotFoundException(getClassName(Tabla.class.getName()));
		}
		
		return tab;
	}
	
}
