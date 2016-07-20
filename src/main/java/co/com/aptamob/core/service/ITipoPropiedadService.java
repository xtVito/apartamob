package co.com.aptamob.core.service;

import java.util.List;
import co.com.aptamob.core.api.TipoPropiedadApi;

public interface ITipoPropiedadService {
	
	public TipoPropiedadApi createTipoPropiedad(TipoPropiedadApi tipoPropiedadRequest);
	public TipoPropiedadApi saveTipoPropiedad(TipoPropiedadApi tipoPropiedadRequest, String codigo);
	public TipoPropiedadApi getTipoPropiedad(String codigo);
	public List<TipoPropiedadApi> getTipoPropiedades();
	public List<TipoPropiedadApi> getTipoPropiedades(String nombre);
	public void deleteTipoPropiedad(TipoPropiedadApi tipoPropiedadRequest, String codigo);
}
