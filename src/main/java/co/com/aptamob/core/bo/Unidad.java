package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="UNIDADES")
public class Unidad extends BaseEntity{
	@Column(name="UNI_NOMBRE")
	private String nombre;
	
	@Column(name="UNI_DIRECCION")
	private String direccion;
	
	@Column(name="UNI_LONGITUD")
	private double longitud;
	
	@Column(name="UNI_LATITUD")
	private double latitud;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ZON_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private Zona zona;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CIU_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private Ciudad ciudad;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="EST_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private Estado estado;
	
	@OneToMany(mappedBy="unidad",
            targetEntity=Propiedad.class,
            cascade= CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Propiedad> propiedades = new ArrayList<Propiedad>();
	
	public Unidad(){}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
}
