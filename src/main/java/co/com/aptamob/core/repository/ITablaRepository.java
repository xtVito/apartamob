package co.com.aptamob.core.repository;

import java.util.List;
import co.com.aptamob.core.bo.Tabla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITablaRepository extends JpaRepository<Tabla, Long> {
	
	@Query("select t from Tabla t where t.id = ?")
	Tabla findById(Long id);
	
	@Query("select t from Tabla t where t.nombre = ?")
	Tabla findByNombre(String nombre);
	
	List<Tabla> findByNombreIgnoreCaseContaining(String nombre);
}
