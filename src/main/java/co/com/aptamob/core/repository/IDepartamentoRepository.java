package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Departamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {
	
	@Query("select d from Departamento d where d.id = ?")
	Departamento findById(Long id);
	
	@Query("select d from Departamento d where d.nombre = ?")
	Departamento findByNombre(String nombre);
	
	List<Departamento> findByNombreIgnoreCaseContaining(String nombre);
}
