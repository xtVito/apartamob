package co.com.aptamob.core.service;

import java.io.InputStream;

import co.com.aptamob.core.api.FotoApi;

public interface IFotoService {
	
	public FotoApi createFoto(String albumId, InputStream archivo);

}
