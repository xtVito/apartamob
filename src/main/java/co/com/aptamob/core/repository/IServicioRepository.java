package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.bo.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IServicioRepository extends JpaRepository<Servicio, Long> {
	
	@Query("select s from Servicio s where s.id = ?")
	Servicio findById(Long id);
	
	@Query("select s from Servicio s where s.nombre = ?")
	Servicio findByNombre(String nombre);
	
	List<Servicio> findByNombreIgnoreCaseContaining(String nombre);
}
