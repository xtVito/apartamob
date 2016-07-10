package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Unidad;
import co.com.aptamob.core.repository.custom.IUnidadRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUnidadRepository extends IUnidadRepositoryCustom, JpaRepository<Unidad, Long> {
	
	@Query("select u from Unidad u where u.id = ?")
	Unidad findById(Long id);
}
