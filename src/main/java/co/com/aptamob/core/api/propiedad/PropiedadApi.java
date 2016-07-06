package co.com.aptamob.core.api.propiedad;

import co.com.aptamob.core.api.album.AlbumApi;
import co.com.aptamob.core.api.estado.EstadoApi;
import co.com.aptamob.core.api.preciopropiedad.PrecioPropiedadApi;
import co.com.aptamob.core.api.servicio.ServicioApi;
import co.com.aptamob.core.api.tipopropiedad.TipoPropiedadApi;
import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Album;
import co.com.aptamob.core.bo.PrecioPropiedad;
import co.com.aptamob.core.bo.Propiedad;
import co.com.aptamob.core.bo.Servicio;

import org.hibernate.validator.constraints.Length;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class PropiedadApi extends BaseApi{
	
	@Length(max=150)
	private String descripcion;
	@Length(max=500)
	private String detalle;
	private String capacidad;
	private String area;
	private TipoPropiedadApi tipo;
	private List<AlbumApi> albumes = new ArrayList<AlbumApi>();
	private List<PrecioPropiedadApi> precios = new ArrayList<PrecioPropiedadApi>();
	private List<ServicioApi> servicios = new ArrayList<ServicioApi>();
	private EstadoApi estado;
	
	public PropiedadApi(Propiedad propiedad){
		this.id = propiedad.getId().toString();
		this.nombre = propiedad.getNombre();
		this.descripcion = propiedad.getDescripcion();
		this.detalle = propiedad.getDetalle();
		this.capacidad = String.valueOf(propiedad.getCapacidad());
		this.area = Double.toString(propiedad.getArea());
		this.tipo = new TipoPropiedadApi(propiedad.getTipoPropiedad());
		this.estado = new EstadoApi(propiedad.getEstado());
		for(Album a : propiedad.getAlbumes()){
			albumes.add(new AlbumApi(a));
		}
		for(PrecioPropiedad pp : propiedad.getPrecios()){
			precios.add(new PrecioPropiedadApi(pp));
		}
		for(Servicio s : propiedad.getServicios()){
			servicios.add(new ServicioApi(s));
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public TipoPropiedadApi getTipo() {
		return tipo;
	}

	public void setTipo(TipoPropiedadApi tipo) {
		this.tipo = tipo;
	}

	public List<AlbumApi> getAlbumes() {
		return albumes;
	}

	public void setAlbumes(List<AlbumApi> albumes) {
		this.albumes = albumes;
	}

	public List<PrecioPropiedadApi> getPrecios() {
		return precios;
	}

	public void setPrecios(List<PrecioPropiedadApi> precios) {
		this.precios = precios;
	}

	public List<ServicioApi> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioApi> servicios) {
		this.servicios = servicios;
	}

	public EstadoApi getEstado() {
		return estado;
	}

	public void setEstado(EstadoApi estado) {
		this.estado = estado;
	}
}
