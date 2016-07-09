package co.com.aptamob.core.api;

import co.com.aptamob.core.base.api.BaseApi;
import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.bo.Zona;

import org.hibernate.validator.constraints.Length;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoApi extends BaseApi{
	
	private List<ZonaApi> zonas = new ArrayList<ZonaApi>();
	
	public DepartamentoApi(){}
	
	public DepartamentoApi(Departamento departamento){
		this.id = departamento.getId().toString();
		this.nombre = departamento.getNombre();
		for(Zona zon : departamento.getZonas()){
			zonas.add(new ZonaApi(zon));
		}
	}

	public List<ZonaApi> getZonas() {
		return zonas;
	}

	public void setZonas(List<ZonaApi> zonas) {
		this.zonas = zonas;
	}
}
