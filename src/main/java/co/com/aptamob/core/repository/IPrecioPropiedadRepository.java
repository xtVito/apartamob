package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.PrecioPropiedad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPrecioPropiedadRepository extends JpaRepository<PrecioPropiedad, Long> {
	
	@Query("select pp from PrecioPropiedad pp where pp.id = ?")
	PrecioPropiedad findById(Long id);
	
	@Query("select pp from PrecioPropiedad pp where pp.propiedad.id = ?")
	List<PrecioPropiedad> findAllByPropiedad(Long idPropiedad);
	
	@Query("select pp from PrecioPropiedad pp where pp.propiedad.id = ? and pp.estado.id = ?")
	List<PrecioPropiedad> findAllByPropiedad(Long idPropiedad, Long idEstado);
}
