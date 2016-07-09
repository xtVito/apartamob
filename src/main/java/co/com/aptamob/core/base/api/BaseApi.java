package co.com.aptamob.core.base.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;

@XmlRootElement
public abstract class BaseApi{
	protected String id;
	
	@NotNull
	@Valid
	@Length(max=50)
	protected String nombre;
	
	public BaseApi(){}
	
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
