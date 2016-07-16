package co.com.aptamob.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import co.com.aptamob.core.bo.Propiedad;

public class IPropiedadRepositoryImpl implements IPropiedadRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
    @Transactional
	public List<Propiedad> findAllCustom(Map<String, String> filtro){
		StringBuilder sb = new StringBuilder();
		List<Object> parametros = new ArrayList<Object>();
		
		sb.append("select p from Propiedad p where 1=1");
		if(filtro.get("estado") != null && filtro.get("estado") != ""){
			sb.append("	and p.estado.id = ?");
			parametros.add(Long.parseLong(filtro.get("estado")));
		}
		
		Query q = em.createQuery(sb.toString());q.toString();
		if(parametros.size() > 0){
			int i = 1;
			for(Object o : parametros){
				q.setParameter(i, o);
				i++;
			}
		}
		
		return (List<Propiedad>)q.getResultList();
	}
}
