package co.com.aptamob.core.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Servicio;

public class ServicioApi extends BaseApi{
	
	private EstadoApi estado;
	
	public ServicioApi(){
		this.estado = new EstadoApi();
	}
	
	public ServicioApi(Servicio servicio){
		this.id = servicio.getId().toString();
		this.nombre = servicio.getNombre();
		this.estado = new EstadoApi(servicio.getEstado());
	}

	public EstadoApi getEstado() {
		return estado;
	}

	public void setEstado(EstadoApi estado) {
		this.estado = estado;
	}
}
