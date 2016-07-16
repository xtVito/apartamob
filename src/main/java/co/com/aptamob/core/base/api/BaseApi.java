package co.com.aptamob.core.base.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
public abstract class BaseApi{
	protected String id;
	
	@NotNull
	@Valid
	@Length(max=50)
	protected String nombre;
	
	@JsonIgnore
	private Map<String, String> filtro;
	
	public BaseApi(){
		this.filtro = new HashMap<String, String>();
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

	public Map<String, String> getFiltro() {
		return filtro;
	}

	public void setFiltro(Map<String, String> filtro) {
		this.filtro = filtro;
	}
}
