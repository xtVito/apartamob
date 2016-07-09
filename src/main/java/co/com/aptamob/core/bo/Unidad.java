package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import co.com.aptamob.core.api.UnidadApi;
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
	
	@OneToOne
	@JoinColumn(name="ZON_ID")
	private Zona zona;
	
	@OneToOne
	@JoinColumn(name="CIU_ID")
	private Ciudad ciudad;
	
	@OneToOne
	@JoinColumn(name="EST_ID")
	private Estado estado;
	
	@OneToMany(mappedBy="unidad",
            targetEntity=Propiedad.class,
            cascade= CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Propiedad> propiedades = new ArrayList<Propiedad>();
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinTable(name="SERVICIOS_UNIDAD",
			joinColumns={@JoinColumn(name="UNI_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="SER_ID", referencedColumnName="ID")})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Servicio> servicios = new ArrayList<Servicio>();
	
	public Unidad(){
		this.zona = new Zona();
		this.ciudad = new Ciudad();
		this.estado = new Estado();
	}
	
	public Unidad(UnidadApi api){
		this();
		this.nombre = api.getNombre();
		this.direccion = api.getDireccion();
		this.longitud = Double.parseDouble(api.getLongitud());
		this.latitud = Double.parseDouble(api.getLatitud());
		this.zona = new Zona();
		this.zona.setId(Long.parseLong(api.getZona().getId()));
		this.ciudad = new Ciudad();
		this.ciudad.setId(Long.parseLong(api.getZona().getCiudades().get(0).getId()));
		this.estado = new Estado();
		this.estado.setId(Long.parseLong(api.getEstado().getId()));
	}

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

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
}
