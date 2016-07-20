package co.com.aptamob.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.aptamob.core.api.TablaApi;
import co.com.aptamob.core.service.ITablaService;
import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/estado")
//@Api(value = "/tabla")
@Component
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class EstadoResource {
	
	@Autowired
	private ITablaService tablaS;
	
	@Context
    protected UriInfo uriInfo;
	
	@PermitAll
	@Path("all")
	@GET
	public Response listarTablas(){
		List<TablaApi> tabs = tablaS.getTablas();
		return Response.ok(tabs.toArray(new TablaApi[tabs.size()])).build();
	}
	
	/*
	@PermitAll
	@Path("{id}")
	@GET
	public Response obtenerTabla(@PathParam("id") String id){
		TablaApi tab = tablaS.getTabla(id);
		return Response.ok(tab).build();
	}*/
	
	
	@PermitAll
	@Path("{nombre}")
	@GET
	public Response obtenerTabla(@PathParam("nombre") String nombre){
		TablaApi tab = tablaS.getTabla(nombre);
		return Response.ok(tab).build();
	}
}
