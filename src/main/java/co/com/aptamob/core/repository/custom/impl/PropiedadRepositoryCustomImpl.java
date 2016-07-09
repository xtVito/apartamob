package co.com.aptamob.core.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.aptamob.core.bo.Propiedad;
import co.com.aptamob.core.repository.custom.IPropiedadRepositoryCustom;

public class PropiedadRepositoryCustomImpl implements IPropiedadRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Propiedad> findAllByFilter(Propiedad filtro){
		em.createQuery("");
		return null;
	}
}
