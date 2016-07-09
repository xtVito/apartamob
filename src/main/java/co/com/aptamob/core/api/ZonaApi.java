package co.com.aptamob.core.api;

import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Ciudad;
import co.com.aptamob.core.bo.Zona;

import org.hibernate.validator.constraints.Length;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

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
