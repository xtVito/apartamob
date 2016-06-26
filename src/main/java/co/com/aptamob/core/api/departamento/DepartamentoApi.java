package co.com.aptamob.core.api.departamento;

import co.com.aptamob.core.api.ciudad.CiudadApi;
import co.com.aptamob.core.bo.Ciudad;
import co.com.aptamob.core.bo.Departamento;

import org.hibernate.validator.constraints.Length;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class DepartamentoApi {
	
	private String id;
	
	@NotNull
	@Length(max=50)
	private String nombre;
	
	private List<CiudadApi> ciudades = new ArrayList<CiudadApi>();
	
	public DepartamentoApi(Departamento departamento){
		this.id = departamento.getUuid().toString();
		this.nombre = departamento.getNombre();
		for(Ciudad ciu : departamento.getCiudades()){
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

	public List<CiudadApi> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<CiudadApi> ciudades) {
		this.ciudades = ciudades;
	}
}
