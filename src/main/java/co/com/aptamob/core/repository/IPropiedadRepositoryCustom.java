package co.com.aptamob.core.repository;

import java.util.List;
import java.util.Map;

import co.com.aptamob.core.api.PropiedadApi;
import co.com.aptamob.core.bo.Propiedad;

public interface IPropiedadRepositoryCustom {

	List<Propiedad> findAllCustom(Map<String, String> filtro);

}
