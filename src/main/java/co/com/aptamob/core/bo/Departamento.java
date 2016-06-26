package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import co.com.aptamob.core.api.departamento.DepartamentoApi;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento extends BaseEntity {
	
	@Column(name="DEP_NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="departamento",
            targetEntity=Ciudad.class,
            cascade= CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	public Departamento(){
		this(UUID.randomUUID());
	}
	
	public Departamento(UUID uuid){
		super(uuid);
	}
	
	public Departamento(DepartamentoApi api){
		this();
		this.nombre = api.getNombre();
	}
	
	public String getClassName(){
		return Departamento.class.getName();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
}
