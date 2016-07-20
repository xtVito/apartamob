package co.com.aptamob.core.bo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import co.com.aptamob.core.base.model.BaseEntity;

@Entity
@Table(name="TABLAS")
public class Tabla extends BaseEntity{
	
	public Tabla(){}
	
	@Column(name="TAB_NOMBRE")
	private String nombre;
	
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinTable(name="ESTADOS_TABLA",
			joinColumns={@JoinColumn(name="TAB_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="EST_ID", referencedColumnName="ID")})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Estado> estados = new ArrayList<Estado>();
	
	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
