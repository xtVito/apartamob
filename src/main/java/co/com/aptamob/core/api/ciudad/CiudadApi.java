package co.com.aptamob.core.api.ciudad;

import co.com.aptamob.core.bo.Ciudad;

import org.hibernate.validator.constraints.Length;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CiudadApi {
	private String id;
	
	@NotNull
	@Length(max=50)
	private String nombre;
	
	public CiudadApi(Ciudad ciudad){
		this.id = ciudad.getUuid().toString();
		this.nombre = ciudad.getNombre();
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
