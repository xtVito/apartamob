package co.com.aptamob.core.api;

import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.TipoPropiedad;

public class TipoPropiedadApi extends BaseApi{
	
	private EstadoApi estado;
	
	public TipoPropiedadApi(){}
	
	public TipoPropiedadApi(TipoPropiedad tipoPropiedad){
		this.id = tipoPropiedad.getId().toString();
		this.nombre = tipoPropiedad.getNombre();
		this.estado = new EstadoApi(tipoPropiedad.getEstado());
	}

	public EstadoApi getEstado() {
		return estado;
	}

	public void setEstado(EstadoApi estado) {
		this.estado = estado;
	}
}
