package co.com.aptamob.core.bo;

import java.util.UUID;

import javax.persistence.*;

import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="CIUDADES")
public class Ciudad extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "DEP_ID")	
	private Departamento departamento;
	
	@Column(name="CIU_NOMBRE")
	private String nombre;
	
	public Ciudad(){
		this(UUID.randomUUID());
	}
	
	public Ciudad(UUID uuid){
		super(uuid);
	}
	
	public String getClassName(){
		return Ciudad.class.getName();
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
}
