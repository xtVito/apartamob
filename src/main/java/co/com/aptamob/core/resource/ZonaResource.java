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
import co.com.aptamob.core.api.ZonaApi;
import co.com.aptamob.core.service.IZonaService;

@Path("/zona")
@Component
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class ZonaResource {
	
	@Autowired
	private IZonaService zonaS;
	
	@Context
    protected UriInfo uriInfo;
	
	@PermitAll
	@POST
	@Path("departamento/{id}")
	public Response crearZona(ZonaApi request,@PathParam("id") String id){
		ZonaApi zon = zonaS.createZona(request,id);
		URI loc = uriInfo.getAbsolutePathBuilder().path(zon.getId()).build();
		return Response.created(loc).entity(zon).build();
	}
	
	@PermitAll
	@PUT
	@Path("{id}")
	public Response editarZona(@PathParam("id") String id, ZonaApi request){
		ZonaApi zon = zonaS.saveZona(request, id);
		return Response.ok(zon).build();
	}
	
	/*@PermitAll
	@DELETE
	@Path("{id}")
	public Response eliminarZona(@PathParam("id") String id){
		zonaS.deleteZona(id);
		return Response.ok().build();
	}*/
	
	@PermitAll
	@Path("all")
	@GET
	public Response listarZonas(){
		List<ZonaApi> zons = zonaS.getZonas();
		return Response.ok(zons.toArray(new ZonaApi[zons.size()])).build();
	}
	
	@PermitAll
	@Path("{id}")
	@GET
	public Response obtenerZona(@PathParam("id") String id){
		ZonaApi zon = zonaS.getZona(id);
		return Response.ok(zon).build();
	}
}
