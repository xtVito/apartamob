package co.com.aptamob.core.api;

import co.com.aptamob.core.bo.PrecioPropiedad;

import org.hibernate.validator.constraints.Length;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrecioPropiedadApi {
	
	private String id;
	
	@NotNull
	@Valid
	private String fecha_inicio;
	
	@NotNull
	@Valid
	private String fecha_fin;
	
	@NotNull
	@Valid
	private String diario;
	
	@NotNull
	@Valid
	private String mensual;
	
	private EstadoApi estado;
	
	public PrecioPropiedadApi(){}
	
	public PrecioPropiedadApi(PrecioPropiedad precio){
		this.id = precio.getId().toString();
		this.fecha_inicio = precio.getDesde().toString();
		this.fecha_fin = precio.getHasta().toString();
		this.diario = precio.getDiario().toString();
		this.mensual = precio.getMensual().toString();
		this.estado = new EstadoApi(precio.getEstado());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getDiario() {
		return diario;
	}

	public void setDiario(String diario) {
		this.diario = diario;
	}

	public String getMensual() {
		return mensual;
	}

	public void setMensual(String mensual) {
		this.mensual = mensual;
	}

	public EstadoApi getEstado() {
		return estado;
	}

	public void setEstado(EstadoApi estado) {
		this.estado = estado;
	}
}
