package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="SERVICIOS")
public class Servicio extends BaseEntity{
	@Column(name="SER_NOMBRE")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="EST_ID")
	private Estado estado;
	
	public Servicio(){}

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
