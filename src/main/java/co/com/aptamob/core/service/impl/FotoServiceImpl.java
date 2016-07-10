package co.com.aptamob.core.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.aptamob.core.api.FotoApi;
import co.com.aptamob.core.base.api.ValidationError;
import co.com.aptamob.core.base.service.BaseService;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.bo.Foto;
import co.com.aptamob.core.exception.ApplicationRuntimeException;
import co.com.aptamob.core.exception.UnprocessableEntityException;
import co.com.aptamob.core.repository.IFotoRepository;
import co.com.aptamob.core.service.IFotoService;

@Service("fotoService")
public class FotoServiceImpl extends BaseService implements IFotoService {
	
	private IFotoRepository fotoR;
	private static final String JPG = ".jpg";
	private static final String DIRECTORY = "C://Users/Stivens/Desktop/";
	
	public FotoServiceImpl(Validator validator) {
		super(validator);
	}
	
	@Autowired
	public FotoServiceImpl(IFotoRepository repository,
			Validator validator) {
		this(validator);
		this.fotoR = repository;
	}
	
	private static final Logger LOG = LoggerFactory.getLogger(UnidadServiceImpl.class);
	
	@Transactional
	public FotoApi createFoto(String albumId, InputStream archivo){
		String nombreArchivo = generaNombreArchivo(albumId);
		String ruta = DIRECTORY + nombreArchivo;
		
		Foto fot = new Foto();
		fot.getAlbum().setId(Long.parseLong(albumId));
		fot.getEstado().setId(Long.parseLong("42"));
		fot.setUrl(nombreArchivo);
		
		saveFile(archivo, ruta);
		
		fotoR.save(fot);
		fot.setUrl(ruta);
		
		return new FotoApi(fot);
	}
	
	private void saveFile(InputStream archivo, String ruta){
		try{
			OutputStream outpuStream = new FileOutputStream(new File(ruta));
			int read = 0;
			byte[] bytes = new byte[1024];
			outpuStream = new FileOutputStream(new File(ruta));
			while ((read = archivo.read(bytes)) != -1) {
			    outpuStream.write(bytes, 0, read);
			}

			outpuStream.flush();
			outpuStream.close();
		}
		catch(Exception e){
			throw new ApplicationRuntimeException(e.getMessage());
		}
	}
	
	private String generaNombreArchivo(String albumId){
		SimpleDateFormat dt = new SimpleDateFormat("yyMMdd-HHmmss");
		String[] fecha = dt.format(new Date()).split("-");
		return fecha[0] + albumId + fecha[1] + JPG;
	}
	
	private void validaCampos(FotoApi request){
		validationErrors = new ArrayList<ValidationError>();
		
		notNull(request.getUrl(), "Url");
		notNull(request.getEstado().getId(), "Estado");
		
		if(validationErrors.size() > 0){
			throw new UnprocessableEntityException(validationErrors, getClassName(Departamento.class.getName()));
		}
	}
	
}
