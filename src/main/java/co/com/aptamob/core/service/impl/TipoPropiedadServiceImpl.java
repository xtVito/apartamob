package co.com.aptamob.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import co.com.aptamob.core.api.TipoPropiedadApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.TipoPropiedad;
import co.com.aptamob.core.exception.DataDuplicateException;
import co.com.aptamob.core.exception.DataNotFoundException;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.repository.ITipoPropiedadRepository;
import co.com.aptamob.core.service.ITipoPropiedadService;

@Service("tipoPropiedadService")
public class TipoPropiedadServiceImpl extends BaseService implements ITipoPropiedadService {
	
	private ITipoPropiedadRepository tipoPropiedadR;
	
	public TipoPropiedadServiceImpl(Validator validator) {
        super(validator);
    }
	
	@Autowired
	public TipoPropiedadServiceImpl(ITipoPropiedadRepository repository, 
			Validator validator) {
        this(validator);
        this.tipoPropiedadR = repository;
    }

	private static final Logger LOG = LoggerFactory.getLogger(TipoPropiedad.class);
	
	@Transactional
	public TipoPropiedadApi createTipoPropiedad(TipoPropiedadApi request) {
		validate(request);
		validaCampos(request);
        
		TipoPropiedad tp = tipoPropiedadR.findByNombre(request.getNombre());
        if(tp != null){
        	throw new DataDuplicateException(getClassName(TipoPropiedad.class.getName()), getClassName(TipoPropiedad.class.getName()));
        }
        
        tp = new TipoPropiedad(request);
        tipoPropiedadR.save(tp);
        
        return new TipoPropiedadApi(tp);
	}

	@Transactional
	public TipoPropiedadApi saveTipoPropiedad(TipoPropiedadApi request, String codigo){
		validate(request);
		notNull(codigo, "Id del tipo de propiedad");
		validaCampos(request);
		
		TipoPropiedad tp = cargaTipoPropiedad(codigo);
		
		if(request.getNombre() != null){
			tp.setNombre(request.getNombre());
		}
		
		tipoPropiedadR.save(tp);
		
		return new TipoPropiedadApi(tp);
	}

	@Transactional
	public TipoPropiedadApi getTipoPropiedad(String codigo) {
		Assert.notNull(codigo);
        
        TipoPropiedad tp = cargaTipoPropiedad(codigo);
        
        return new TipoPropiedadApi(tp);
	}

	@Transactional
	public List<TipoPropiedadApi> getTipoPropiedades(){
		List<TipoPropiedadApi> apis = new ArrayList<TipoPropiedadApi> ();
		
		List<TipoPropiedad> tps = tipoPropiedadR.findAll();
		if(tps == null || tps.size() == 0){
			throw new DataNotFoundException(getClassName(TipoPropiedad.class.getName()));
		}
		
		for(TipoPropiedad tp : tps){
			apis.add(new TipoPropiedadApi(tp));
		}
		
		return apis;
	}

	@Transactional
	public List<TipoPropiedadApi> getTipoPropiedades(String nombre){
		Assert.notNull(nombre);
		List<TipoPropiedadApi> apis = new ArrayList<TipoPropiedadApi> ();
		
		List<TipoPropiedad> tps = tipoPropiedadR.findByNombreIgnoreCaseContaining(nombre);
		if(tps == null || tps.size() == 0){
			throw new DataNotFoundException(getClassName(TipoPropiedad.class.getName()));
		}
		
		for(TipoPropiedad tp : tps){
			apis.add(new TipoPropiedadApi(tp));
		}
		
		return apis;
	}

	@Transactional
	public void deleteTipoPropiedad(TipoPropiedadApi tipoPropiedadRequest, String codigo) {
		// TODO Auto-generated method stub		
	}

	
	private TipoPropiedad cargaTipoPropiedad(String identificador){
		TipoPropiedad tp = null;
		tp = tipoPropiedadR.findById(Long.parseLong(identificador));
		
		if(tp == null){
			throw new DataNotFoundException(getClassName(TipoPropiedad.class.getName()));
		}
		
		return tp;
	}	
	
	private void validaCampos(TipoPropiedadApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(TipoPropiedad.class.getName()));
		}
	}
	
	
	@Autowired
	public void setTipoPropiedadR(ITipoPropiedadRepository tipoPropiedadR) {
		this.tipoPropiedadR = tipoPropiedadR;
	}
}
