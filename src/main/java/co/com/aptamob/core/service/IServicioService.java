package co.com.aptamob.core.service;

import java.util.List;

import co.com.aptamob.core.api.ServicioApi;

public interface IServicioService {
	public ServicioApi createServicio(ServicioApi servicioRequest);
	public ServicioApi saveServicio(ServicioApi servicioRequest, String codigo);
	public ServicioApi getServicio(String codigo);
	public List<ServicioApi> getServicios();
	public List<ServicioApi> getServicios(String nombre);
	public void deleteServicio(ServicioApi ServicioRequest, String codigo);
}
