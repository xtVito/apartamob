package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAlbumRepository extends JpaRepository<Album, Long> {
	
	@Query("select a from Album a where a.id = ?")
	Album findById(Long id);
	
	@Query("select a from Album a where a.propiedad.id = ?")
	List<Album> findAllByPropiedad(Long idPropiedad);
	
	@Query("select a from Album a where a.propiedad.id = ? and a.estado.id = ?")
	List<Album> findAllByPropiedad(Long idPropiedad, Long idEstado);
}
