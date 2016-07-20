package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IZonaRepository extends JpaRepository<Zona, Long> {
	
	@Query("select z from Zona z where z.id = ?")
	Zona findById(Long id);
	
	@Query("select z from Zona z where z.nombre = ?")
	Zona findByNombre(String nombre);
	
	List<Zona> findByNombreIgnoreCaseContaining(String nombre);
}
