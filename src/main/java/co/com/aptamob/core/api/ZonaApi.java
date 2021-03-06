package co.com.aptamob.core.api;

import co.com.aptamob.core.api.CiudadApi;
import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Ciudad;
import co.com.aptamob.core.bo.Zona;
import java.util.ArrayList;
import java.util.List;

public class ZonaApi extends BaseApi{
	
	private List<CiudadApi> ciudades = new ArrayList<CiudadApi>();
	
	public ZonaApi(){}
	
	public ZonaApi(Zona zona){
		this.id = zona.getId().toString();
		this.nombre = zona.getNombre();
		for(Ciudad ciu :  zona.getCiudades()){
			ciudades.add(new CiudadApi(ciu));
		}
	}

	public List<CiudadApi> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<CiudadApi> ciudades) {
		this.ciudades = ciudades;
	}
}
