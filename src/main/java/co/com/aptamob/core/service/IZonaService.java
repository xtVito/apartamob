package co.com.aptamob.core.service;

import java.util.List;
import co.com.aptamob.core.api.ZonaApi;

public interface IZonaService {
	
	public ZonaApi createZona(ZonaApi request,String id);
	public ZonaApi saveZona(ZonaApi request, String id);
	public ZonaApi getZona(String id);
	public List<ZonaApi> getZonas();
	public List<ZonaApi> getZonas(String nombre);
	//public void deleteZona(String codigo);
}
