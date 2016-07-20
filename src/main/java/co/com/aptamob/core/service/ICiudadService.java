package co.com.aptamob.core.service;

import java.util.List;
import co.com.aptamob.core.api.CiudadApi;

public interface ICiudadService {
	public CiudadApi createCiudad(CiudadApi ciudadRequest,String codigo);
	public CiudadApi saveCiudad(CiudadApi ciudadRequest, String codigo);
	public CiudadApi getCiudad(String codigo);
	public List<CiudadApi> getCiudades();
	public List<CiudadApi> getCiudades(String nombre);
	//public void deleteDepartamento(String codigo);
}
