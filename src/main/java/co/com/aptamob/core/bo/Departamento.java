package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import co.com.aptamob.core.api.DepartamentoApi;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento extends BaseEntity {
	
	@Column(name="DEP_NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="departamento",
            targetEntity=Zona.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Zona> zonas = new ArrayList<Zona>();
	
	@OneToMany(mappedBy="departamento",
            targetEntity=Ciudad.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	public Departamento(){}
	
	public Departamento(DepartamentoApi api){
		this();
		this.nombre = api.getNombre();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
}
