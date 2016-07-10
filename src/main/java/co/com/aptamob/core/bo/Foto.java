package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import co.com.aptamob.core.api.FotoApi;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="FOTOS")
public class Foto extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "ALB_ID")
	private Album album;
	
	@OneToOne
	@JoinColumn(name="EST_ID")
	private Estado estado;
	
	@Column(name="FOT_URL")
	private String url;
	
	public Foto(){
		this.album = new Album();
		this.estado = new Estado();
	}
	
	public Foto(FotoApi api){
		this();
		this.estado.setId(Long.parseLong(api.getEstado().getId()));
		this.url = api.getUrl();
	}

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
