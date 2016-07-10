package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Foto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFotoRepository extends JpaRepository<Foto, Long> {
	
	@Query("select f from Foto f where f.id = ?")
	Foto findById(Long id);
	
	@Query("select f from Foto f where f.album.id = ?")
	List<Foto> findAllByAlbum(Long idAlbum);
	
	@Query("select f from Foto f where f.album.id = ? and f.estado.id = ?")
	List<Foto> findAllByAlbum(Long idAlbum, Long idEstado);
}
