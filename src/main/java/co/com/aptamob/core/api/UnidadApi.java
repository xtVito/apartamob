package co.com.aptamob.core.api;

import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Servicio;
import co.com.aptamob.core.bo.Unidad;

import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

public class UnidadApi extends BaseApi{
	
	@NotNull
	@Valid
	@Length(max=150)
	private String direccion;
	
	@NotNull
	@Valid
	private String longitud;
	
	@NotNull
	@Valid
	private String latitud;
	
	@NotNull
	@Valid
	private ZonaApi zona;	
	
	private EstadoApi estado;
	//private List<PropiedadApi> propiedades;
	private List<ServicioApi> servicios = new ArrayList<ServicioApi>();
	
	public UnidadApi(){}
	
	public UnidadApi(Unidad unidad){
		this.id = unidad.getId().toString();
		this.nombre = unidad.getNombre();
		this.direccion = unidad.getDireccion();
		this.longitud = Double.toString(unidad.getLongitud());
		this.latitud = Double.toString(unidad.getLatitud());
		this.zona = new ZonaApi(unidad.getZona());
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
