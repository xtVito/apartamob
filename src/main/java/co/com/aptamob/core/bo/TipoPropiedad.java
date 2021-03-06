package co.com.aptamob.core.bo;

import javax.persistence.*;

import co.com.aptamob.core.api.TipoPropiedadApi;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="TIPOS_PROPIEDAD")
public class TipoPropiedad extends BaseEntity{
	
	@Column(name="TPR_NOMBRE")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="EST_ID")
	private Estado estado;
	
	public TipoPropiedad(){
		this.estado = new Estado();
	}
	
	public TipoPropiedad(TipoPropiedadApi api){
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
