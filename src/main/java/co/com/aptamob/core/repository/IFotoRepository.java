package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Foto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFotoRepository extends JpaRepository<Foto, Long> {

}
