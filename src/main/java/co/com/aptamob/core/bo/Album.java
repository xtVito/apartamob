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
	
	@OneToOne
	@JoinColumn(name="EST_ID")
	private Estado estado;
	
	@Column(name="ALB_NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="album",
            targetEntity=Foto.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Foto> fotos = new ArrayList<Foto>();
	
	public Album(){
		this.propiedad = new Propiedad();
		this.estado = new Estado();
	}
	
	public Album(AlbumApi api){
		this();
		this.nombre = api.getNombre();
		this.estado.setId(Long.parseLong(api.getEstado().getId()));
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
