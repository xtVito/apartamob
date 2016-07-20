package co.com.aptamob.core.service;

import co.com.aptamob.core.api.TablaApi;
import java.util.List;

public interface ITablaService {
	
	public TablaApi getTabla(String codigo);
	public List<TablaApi> getTablas();
	public List<TablaApi> getTablas(String nombre);
}
