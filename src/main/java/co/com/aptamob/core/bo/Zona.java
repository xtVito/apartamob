package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import co.com.aptamob.core.api.ZonaApi;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="ZONAS")
public class Zona extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "DEP_ID")	
	private Departamento departamento;
	
	@Column(name="ZON_NOMBRE")
	private String nombre;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinTable(name="CIUDADES_ZONA",
			joinColumns={@JoinColumn(name="ZON_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="CIU_ID", referencedColumnName="ID")})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	public Zona(){
		
	}
	
	public Zona(ZonaApi api){
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

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
}
