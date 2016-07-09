package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEstadoRepository extends JpaRepository<Estado, Long> {
	
	@Query("select e from Estado e where e.id = ?")
	Estado findById(Long id);
}
