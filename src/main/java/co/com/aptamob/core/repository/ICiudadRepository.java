package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Ciudad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {
	
	@Query("select c from Ciudad c where c.id = ?")
	Ciudad findById(Long id);
	
	@Query("select c from Ciudad c join c.departamento d where d.id = ?")
	List<Ciudad> findByDepartamentoId(String id);
	
	List<Ciudad> findByNombreIgnoreCaseContaining(String nombre);
}
