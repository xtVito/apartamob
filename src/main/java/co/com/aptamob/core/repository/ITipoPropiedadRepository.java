package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.TipoPropiedad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITipoPropiedadRepository extends JpaRepository<TipoPropiedad, Long> {
	
	@Query("select tp from TipoPropiedad tp where tp.id = ?")
	TipoPropiedad findById(Long id);
}
