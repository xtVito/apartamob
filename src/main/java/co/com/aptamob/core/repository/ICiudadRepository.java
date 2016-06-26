package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Ciudad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {
	
	@Query("select c from Ciudad c where c.uuid = ?")
	Ciudad findByUuid(String uuid);
	
	@Query("select c from Ciudad c join c.departamento d where d.uuid = ?")
	List<Ciudad> findByDepartamentoId(String uuid);
	
	List<Ciudad> findByNombreIgnoreCaseContaining(String nombre);
}
