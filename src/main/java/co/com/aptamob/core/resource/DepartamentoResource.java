package co.com.aptamob.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import co.com.aptamob.core.api.departamento.DepartamentoApi;
import co.com.aptamob.core.service.IDepartamentoService;
import co.com.aptamob.security.config.ApplicationConfig;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/departamento")
@Component
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class DepartamentoResource {
	
	@Autowired
	private IDepartamentoService departamentoS;
	
	@Context
    protected UriInfo uriInfo;
	
	@PermitAll
	@POST
	public Response crearDepartamento(DepartamentoApi request){
		DepartamentoApi dep = departamentoS.createDepartamento(request);
		URI loc = uriInfo.getAbsolutePathBuilder().path(dep.getId()).build();
		return Response.created(loc).entity(dep).build();
	}
	
	@PermitAll
	@Path("all")
	@GET
	public Response listarDepartamentos(){
		List<DepartamentoApi> deps = departamentoS.getDepartamentos();
		return Response.ok(deps.toArray(new DepartamentoApi[deps.size()])).build();
	}
}
