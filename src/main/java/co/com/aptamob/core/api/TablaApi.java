package co.com.aptamob.core.api;

import co.com.aptamob.core.api.EstadoApi;
import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Estado;
import co.com.aptamob.core.bo.Tabla;
import java.util.ArrayList;
import java.util.List;

public class TablaApi extends BaseApi{
	
	private List<EstadoApi> estados = new ArrayList<EstadoApi>();
	
	public TablaApi(Tabla tabla){
		this.id = tabla.getId().toString();
		this.nombre = tabla.getNombre();
		for(Estado est :  tabla.getEstados()){
			estados.add(new EstadoApi(est));
		}
	}

	public List<EstadoApi> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadoApi> estados) {
		this.estados = estados;
	}
}
