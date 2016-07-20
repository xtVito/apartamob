package co.com.aptamob.core.resource;

import java.net.URI;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.aptamob.core.api.CiudadApi;
import co.com.aptamob.core.service.ICiudadService;

@Path("/ciudad")
@Component
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class CiudadResource {

	@Autowired
	private ICiudadService ciudadS;
	
	@Context
    protected UriInfo uriInfo;
	
	@PermitAll
	@POST
	@Path("departamento/{id}")
	public Response crearCiudad(CiudadApi request,@PathParam("id") String id){
		CiudadApi ciu = ciudadS.createCiudad(request,id);
		URI loc = uriInfo.getAbsolutePathBuilder().path(ciu.getId()).build();
		return Response.created(loc).entity(ciu).build();
	}
		
	@PermitAll
	@PUT
	@Path("{id}")
	public Response editarCiudad(@PathParam("id") String id, CiudadApi request){
		CiudadApi ciu = ciudadS.saveCiudad(request, id);
		return Response.ok(ciu).build();
	}
	
	@PermitAll
	@Path("all")
	@GET
	public Response listarCiudades(){
		List<CiudadApi> cius = ciudadS.getCiudades();
		return Response.ok(cius.toArray(new CiudadApi[cius.size()])).build();
	}
	
	@PermitAll
	@Path("{id}")
	@GET
	public Response obtenerCiudad(@PathParam("id") String id){
		CiudadApi ciu = ciudadS.getCiudad(id);
		return Response.ok(ciu).build();
	}
	
}
