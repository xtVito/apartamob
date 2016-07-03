package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="FOTOS")
public class Foto extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "ALB_ID")
	private Album album;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="EST_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private Estado estado;
	
	@Column(name="FOT_URL")
	private String url;
	
	private Foto(){}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
