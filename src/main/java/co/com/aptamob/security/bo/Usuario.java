package co.com.aptamob.security.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import co.com.aptamob.core.base.model.BaseEntity;
import co.com.aptamob.core.bo.Propiedad;
import co.com.aptamob.core.bo.Estado;

@Entity
@Table(name="USUARIOS")
public class Usuario extends BaseEntity{
	@Column(name="USU_NOMBRE")
	private String nombre;
	
	@Column(name="USU_CLAVE")
	private String usuario;
	
	@Column(name="USU_KEY")
	private String key;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ROL_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private Rol rol;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="EST_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private Estado estado;
	
	@OneToMany(mappedBy="usuario",
            targetEntity=Propiedad.class,
            cascade= CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Propiedad> albumes = new ArrayList<Propiedad>();
	
	public Usuario(){}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Propiedad> getAlbumes() {
		return albumes;
	}

	public void setAlbumes(List<Propiedad> albumes) {
		this.albumes = albumes;
	}
}
