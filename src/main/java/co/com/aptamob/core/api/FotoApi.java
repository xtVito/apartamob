package co.com.aptamob.core.api;

import co.com.aptamob.core.bo.Foto;

import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FotoApi{
	
	private String id;
	
	@Length(max=150)
	private String url;
	
	private EstadoApi estado;
	
	public FotoApi(){}
	
	public FotoApi(Foto foto){
		this.id = foto.getId().toString();
		this.url = foto.getUrl();
		this.estado = new EstadoApi(foto.getEstado());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public EstadoApi getEstado() {
		return estado;
	}

	public void setEstado(EstadoApi estado) {
		this.estado = estado;
	}
}
