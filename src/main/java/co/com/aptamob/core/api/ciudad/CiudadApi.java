package co.com.aptamob.core.api.ciudad;

import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Ciudad;

public class CiudadApi extends BaseApi{
	
	public CiudadApi(Ciudad ciudad){
		this.id = ciudad.getId().toString();
		this.nombre = ciudad.getNombre();
	}
}
