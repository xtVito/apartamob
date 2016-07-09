package co.com.aptamob.core.repository;

import co.com.aptamob.core.bo.Propiedad;
import co.com.aptamob.core.repository.custom.IPropiedadRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPropiedadRepository extends IPropiedadRepositoryCustom, JpaRepository<Propiedad, Long> {

}
