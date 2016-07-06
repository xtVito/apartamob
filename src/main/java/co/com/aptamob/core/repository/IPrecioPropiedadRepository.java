package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.PrecioPropiedad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPrecioPropiedadRepository extends JpaRepository<PrecioPropiedad, Long> {

}
