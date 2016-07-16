package co.com.aptamob.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import co.com.aptamob.core.api.PropiedadApi;
import co.com.aptamob.core.service.IPropiedadService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/propiedad")
@Component
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
@Consumes({MediaType.APPLICATION_JSON})
public class PropiedadResource {
	
	@Autowired
	private IPropiedadService propiedadS;
	
	@Context
    protected UriInfo uriInfo;
	
	@PermitAll
	@GET
	public Response listarPropiedades(@QueryParam("estado") String idEstado){
		PropiedadApi request = new PropiedadApi();
		
		if(idEstado != null){
			request.getFiltro().put("estado", idEstado);
		}
		
		List<PropiedadApi> props = propiedadS.getPropiedades(request);
		return Response.ok(props.toArray(new PropiedadApi[props.size()])).build();
	}
}
