package co.com.aptamob.core.api;

import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Estado;

public class EstadoApi extends BaseApi{
	
	public EstadoApi(){}
	
	public EstadoApi(Estado estado){
		this.id = estado.getId().toString();
		this.nombre = estado.getNombre();
	}
}
