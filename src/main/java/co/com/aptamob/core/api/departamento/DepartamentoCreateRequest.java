package co.com.aptamob.core.api.departamento;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DepartamentoCreateRequest {
	@NotNull
	@Valid
	private String nombre;
	
	public DepartamentoCreateRequest(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
