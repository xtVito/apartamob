package co.com.aptamob.core.api.departamento;

import co.com.aptamob.core.api.zona.ZonaApi;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.bo.Zona;

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
	
	private List<ZonaApi> zonas = new ArrayList<ZonaApi>();
	
	public DepartamentoApi(Departamento departamento){
		this.id = departamento.getId().toString();
		this.nombre = departamento.getNombre();
		for(Zona zon : departamento.getZonas()){
			zonas.add(new ZonaApi(zon));
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

	public List<ZonaApi> getZonas() {
		return zonas;
	}

	public void setZonas(List<ZonaApi> zonas) {
		this.zonas = zonas;
	}
}
