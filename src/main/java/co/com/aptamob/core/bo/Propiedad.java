package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import co.com.aptamob.core.api.PropiedadApi;
import co.com.aptamob.core.base.model.BaseEntity;
import co.com.aptamob.security.bo.Usuario;

@Entity
@Table(name="PROPIEDADES")
public class Propiedad extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "UNI_ID")
	private Unidad unidad;
	
	@ManyToOne
	@JoinColumn(name = "USU_ID")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="TPR_ID")
	private TipoPropiedad tipoPropiedad;
	
	@OneToOne
	@JoinColumn(name="EST_ID")
	private Estado estado;
	
	@Column(name="PRO_NOMBRE")
	private String nombre;
	
	@Column(name="PRO_DESCRIP_CORTA")
	private String descripcion;
	
	@Column(name="PRO_DESCRIP")
	private String detalle;
	
	@Column(name="PRO_CAPACIDAD")
	private int capacidad;
	
	@Column(name="PRO_AREA")
	private double area;
	
	@OneToMany(mappedBy="propiedad",
            targetEntity=Album.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Album> albumes = new ArrayList<Album>();
	
	/*@OneToMany(mappedBy="propiedad",
            targetEntity=PrecioPropiedad.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PrecioPropiedad> precios;
	
	@OneToMany
	@JoinTable(name="SERVICIOS_PROPIEDAD",
			joinColumns={@JoinColumn(name="PRO_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="SER_ID", referencedColumnName="ID")})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Servicio> servicios;*/
	
	public Propiedad(){
		this.unidad = new Unidad();
		this.usuario = new Usuario();
		this.tipoPropiedad = new TipoPropiedad();
		this.estado = new Estado();
		//this.precios = new ArrayList<PrecioPropiedad>();
		//this.servicios = new ArrayList<Servicio>();
	}
	
	public Propiedad(PropiedadApi api){
		this();
		this.nombre = api.getNombre();
		this.descripcion = api.getDescripcion();
		this.detalle = api.getDetalle();
		this.capacidad = Integer.parseInt(api.getCapacidad());
		this.area = Double.parseDouble(api.getArea());
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoPropiedad getTipoPropiedad() {
		return tipoPropiedad;
	}

	public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public List<Album> getAlbumes() {
		return albumes;
	}

	public void setAlbumes(List<Album> albumes) {
		this.albumes = albumes;
	}

	/*public List<PrecioPropiedad> getPrecios() {
		return precios;
	}

	public void setPrecios(List<PrecioPropiedad> precios) {
		this.precios = precios;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}*/
}
