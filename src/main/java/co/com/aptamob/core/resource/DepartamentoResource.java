package co.com.aptamob.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import co.com.aptamob.core.api.DepartamentoApi;
import co.com.aptamob.core.api.ZonaApi;
import co.com.aptamob.core.service.IDepartamentoService;
import co.com.aptamob.security.config.ApplicationConfig;
/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;*/

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/departamento")
@Component
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
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
	@PUT
	@Path("{id}")
	public Response editarDepartamento(@PathParam("id") String id, DepartamentoApi request){
		DepartamentoApi dep = departamentoS.saveDepartamento(request, id);
		return Response.ok(dep).build();
	}
	
	@PermitAll
	@DELETE
	@Path("{id}")
	public Response eliminarDepartamento(@PathParam("id") String id){
		departamentoS.deleteDepartamento(id);
		return Response.ok().build();
	}
	
	@PermitAll
	@Path("all")
	@GET
	public Response listarDepartamentos(){
		List<DepartamentoApi> deps = departamentoS.getDepartamentos();
		return Response.ok(deps.toArray(new DepartamentoApi[deps.size()])).build();
	}
	
	@PermitAll
	@Path("{id}")
	@GET
	public Response obtenerDepartamento(@PathParam("id") String id){
		DepartamentoApi dep = departamentoS.getDepartamento(id);
		return Response.ok(dep).build();
	}
	
	@PermitAll
	@Path("{id}/zonas")
	@GET
	public Response listarZonasDepartamento(@PathParam("id") String id){
		DepartamentoApi dep = departamentoS.getDepartamento(id);
		return Response.ok(dep.getZonas().toArray(new ZonaApi[dep.getZonas().size()])).build();
	}
}
