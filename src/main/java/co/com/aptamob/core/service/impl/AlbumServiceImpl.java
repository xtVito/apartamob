package co.com.aptamob.core.service.impl;

import java.util.ArrayList;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import co.com.aptamob.core.api.AlbumApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Album;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.exception.DataNotFoundException;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.repository.IAlbumRepository;
import co.com.aptamob.core.service.IAlbumService;

public class AlbumServiceImpl extends BaseService implements IAlbumService{
	
	private IAlbumRepository albumR;

	public AlbumServiceImpl(Validator validator) {
		super(validator);
	}
	
	@Autowired
	public AlbumServiceImpl(IAlbumRepository repository, 
			Validator validator) {
		this(validator);
		this.albumR = repository;
	}
	
	private static final Logger LOG = LoggerFactory.getLogger(AlbumServiceImpl.class);
	
	@Transactional
	public AlbumApi createAlbum(AlbumApi request){
		validate(request);
		validaCampos(request);
		
		Album alb = new Album(request);
		albumR.save(alb);
		alb = albumR.findById(alb.getId());
		
		return new AlbumApi(alb);
	}
	
	@Transactional
	public AlbumApi getAlbum(String codigo){
		notNull(codigo, "Código");
		
		Album alb = cargaAlbum(codigo);
		
		return new AlbumApi(alb);
	}
	
	private Album cargaAlbum(String identificador){
		Album alb = null;
		
		alb = albumR.findById(Long.parseLong(identificador));
		
		if(alb == null){
			throw new DataNotFoundException(getClassName(Album.class.getName()));
		}
		
		return alb;
	}
	
	private void validaCampos(AlbumApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getNombre(), "Nombre");
		notNull(request.getEstado().getId(), "Estado");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Departamento.class.getName()));
		}
	}
	
	@Autowired
	public void setAlbumR(IAlbumRepository albumR) {
		this.albumR = albumR;
	}
}
