package co.com.aptamob.core.base.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@Transient
	private Map<String, String> filtro;
	
    public BaseEntity() {
    	this.filtro = new HashMap<String, String>();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, String> getFiltro() {
		return filtro;
	}

	public void setFiltro(Map<String, String> filtro) {
		this.filtro = filtro;
	}
}