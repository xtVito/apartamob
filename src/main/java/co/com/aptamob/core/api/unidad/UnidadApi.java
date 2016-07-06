package co.com.aptamob.core.api.unidad;

import co.com.aptamob.core.api.estado.EstadoApi;
import co.com.aptamob.core.api.propiedad.PropiedadApi;
import co.com.aptamob.core.api.servicio.ServicioApi;
import co.com.aptamob.core.api.zona.ZonaApi;
import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Servicio;
import co.com.aptamob.core.bo.Unidad;

import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class UnidadApi extends BaseApi{
	
	@Length(max=150)
	private String direccion;
	private String longitud;
	private String latitud;
	private ZonaApi zona;
	private EstadoApi estado;
	//private List<PropiedadApi> propiedades;
	private List<ServicioApi> servicios = new ArrayList<ServicioApi>();
	
	public UnidadApi(Unidad unidad){
		this.id = unidad.getId().toString();
		this.nombre = unidad.getNombre();
		this.direccion = unidad.getDireccion();
		this.longitud = Double.toString(unidad.getLongitud());
		this.latitud = Double.toString(unidad.getLatitud());
		this.estado = new EstadoApi(unidad.getEstado());
		for(Servicio s : unidad.getServicios()){
			servicios.add(new ServicioApi(s));
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public ZonaApi getZona() {
		return zona;
	}

	public void setZona(ZonaApi zona) {
		this.zona = zona;
	}

	public EstadoApi getEstado() {
		return estado;
	}

	public void setEstado(EstadoApi estado) {
		this.estado = estado;
	}

	/*public List<PropiedadApi> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<PropiedadApi> propiedades) {
		this.propiedades = propiedades;
	}*/

	public List<ServicioApi> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioApi> servicios) {
		this.servicios = servicios;
	}
}
