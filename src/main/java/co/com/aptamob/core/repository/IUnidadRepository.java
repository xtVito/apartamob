package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Unidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUnidadRepository extends JpaRepository<Unidad, Long> {
	
	@Query("select d from Departamento d where d.id = ?")
	Unidad findById(Long id);
}
