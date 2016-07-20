package co.com.aptamob.core.bo;

import javax.persistence.*;
import co.com.aptamob.core.api.ServicioApi;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="SERVICIOS")
public class Servicio extends BaseEntity{
	
	@Column(name="SER_NOMBRE")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="EST_ID")
	private Estado estado;
	
	public Servicio(){
		this.estado = new Estado();
	}
	
	public Servicio(ServicioApi api){
		this();	
		this.estado.setId(Long.parseLong(api.getEstado().getId()));
		this.nombre = api.getNombre();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
