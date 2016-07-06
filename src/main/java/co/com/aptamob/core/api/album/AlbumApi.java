package co.com.aptamob.core.api.album;

import co.com.aptamob.core.api.estado.EstadoApi;
import co.com.aptamob.core.api.foto.FotoApi;
import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Album;
import co.com.aptamob.core.bo.Foto;

import org.hibernate.validator.constraints.Length;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class AlbumApi extends BaseApi{
	
	private List<FotoApi> fotos = new ArrayList<FotoApi>();
	
	private EstadoApi estado;
	
	public AlbumApi(Album album){
		this.id = album.getId().toString();
		this.nombre = album.getNombre();
		for(Foto f : album.getFotos()){
			fotos.add(new FotoApi(f));
		}
		this.estado = new EstadoApi(album.getEstado());
	}

	public List<FotoApi> getFotos() {
		return fotos;
	}

	public void setFotos(List<FotoApi> fotos) {
		this.fotos = fotos;
	}

	public EstadoApi getEstado() {
		return estado;
	}

	public void setEstado(EstadoApi estado) {
		this.estado = estado;
	}
}
