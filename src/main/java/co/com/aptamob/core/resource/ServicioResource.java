package co.com.aptamob.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.aptamob.core.api.ServicioApi;
import co.com.aptamob.core.service.IServicioService;
import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/servicio")
@Component
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class ServicioResource {
	
	@Autowired
	private IServicioService servicioS;
	
	@Context
    protected UriInfo uriInfo;
	
	@PermitAll
	@POST
	public Response crearServicio(ServicioApi request){
		ServicioApi ser = servicioS.createServicio(request);
		URI loc = uriInfo.getAbsolutePathBuilder().path(ser.getId()).build();
		return Response.created(loc).entity(ser).build();
	}
	
	@PermitAll
	@Path("all")
	@GET
	public Response listarServicios(){
		List<ServicioApi> sers = servicioS.getServicios();
		return Response.ok(sers.toArray(new ServicioApi[sers.size()])).build();
	}
	
	@PermitAll
	@Path("{id}")
	@GET
	public Response obtenerServicio(@PathParam("id") String id){
		ServicioApi ser = servicioS.getServicio(id);
		return Response.ok(ser).build();
	}
	
}
