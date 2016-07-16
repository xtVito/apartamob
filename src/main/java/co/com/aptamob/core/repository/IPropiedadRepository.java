package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Propiedad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPropiedadRepository extends JpaRepository<Propiedad, Long>, IPropiedadRepositoryCustom {
	
	@Query("select p from Propiedad p where p.id = ?")
	Propiedad findById(Long id);
}
