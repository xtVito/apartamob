package co.com.aptamob.core.api.zona;

import co.com.aptamob.core.api.ciudad.CiudadApi;
import co.com.aptamob.core.bo.Ciudad;
import co.com.aptamob.core.bo.Zona;

import org.hibernate.validator.constraints.Length;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ZonaApi {
	private String id;
	
	@NotNull
	@Length(max=50)
	private String nombre;
	
	private List<CiudadApi> ciudades = new ArrayList<CiudadApi>();
	
	public ZonaApi(Zona zona){
		this.id = zona.getId().toString();
		this.nombre = zona.getNombre();
		for(Ciudad ciu :  zona.getCiudades()){
			ciudades.add(new CiudadApi(ciu));
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
