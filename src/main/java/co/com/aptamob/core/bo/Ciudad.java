package co.com.aptamob.core.bo;

import javax.persistence.*;

import co.com.aptamob.core.api.CiudadApi;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="CIUDADES")
public class Ciudad extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "DEP_ID")	
	private Departamento departamento;
	
	@Column(name="CIU_NOMBRE")
	private String nombre;
	
	public Ciudad(){}
	
	public Ciudad(CiudadApi api){
		this();
		this.nombre = api.getNombre();
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public List<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}*/
}
