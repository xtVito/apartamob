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
import co.com.aptamob.core.api.TipoPropiedadApi;
import co.com.aptamob.core.service.ITipoPropiedadService;

@Path("/tipoPropiedad")
@Component
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class TipoPropiedadResource {

	@Autowired
	private ITipoPropiedadService tipoPropiedadS;
	
	@Context
    protected UriInfo uriInfo;
	
	@PermitAll
	@POST
	public Response crearTipoPropiedad(TipoPropiedadApi request){
		TipoPropiedadApi tp = tipoPropiedadS.createTipoPropiedad(request);
		URI loc = uriInfo.getAbsolutePathBuilder().path(tp.getId()).build();
		return Response.created(loc).entity(tp).build();
	}
	
	@PermitAll
	@Path("all")
	@GET
	public Response listarTipoPropiedades(){
		List<TipoPropiedadApi> tps = tipoPropiedadS.getTipoPropiedades();
		return Response.ok(tps.toArray(new TipoPropiedadApi[tps.size()])).build();
	}
		
	@PermitAll
	@Path("{id}")
	@GET
	public Response obtenerTipoPropiedad(@PathParam("id") String id){
		TipoPropiedadApi tp = tipoPropiedadS.getTipoPropiedad(id);
		return Response.ok(tp).build();
	}
	
	@PermitAll
	@PUT
	@Path("{id}")
	public Response editarTipoPropiedad(@PathParam("id") String id, TipoPropiedadApi request){
		TipoPropiedadApi tp = tipoPropiedadS.saveTipoPropiedad(request, id);
		return Response.ok(tp).build();
	}
	
}
