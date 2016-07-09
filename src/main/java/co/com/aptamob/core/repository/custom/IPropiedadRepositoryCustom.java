package co.com.aptamob.core.repository.custom;

import java.util.List;

import co.com.aptamob.core.bo.Propiedad;

public interface IPropiedadRepositoryCustom {

	List<Propiedad> findAllByFilter(Propiedad filtro);

}
