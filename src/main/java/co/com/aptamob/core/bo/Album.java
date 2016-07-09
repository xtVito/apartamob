package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import co.com.aptamob.core.api.AlbumApi;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="ALBUMES")
public class Album extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "PRO_ID")
	private Propiedad propiedad;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="EST_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private Estado estado;
	
	@Column(name="ALB_NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="album",
            targetEntity=Foto.class,
            cascade= CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Foto> fotos = new ArrayList<Foto>();
	
	public Album(){}
	
	public Album(AlbumApi api){
		this.nombre = api.getNombre();
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
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

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
}
