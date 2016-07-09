package co.com.aptamob.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import co.com.aptamob.core.api.UnidadApi;
import co.com.aptamob.core.service.IUnidadService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/unidad")
@Component
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class UnidadResource {
	
	@Autowired
	private IUnidadService unidadS;
	
	@Context
    protected UriInfo uriInfo;
	
	@PermitAll
	@POST
	public Response crearUnidad(UnidadApi request){
		UnidadApi uni = unidadS.createUnidad(request);
		URI loc = uriInfo.getAbsolutePathBuilder().path(uni.getId()).build();
		return Response.created(loc).entity(uni).build();
	}
}
