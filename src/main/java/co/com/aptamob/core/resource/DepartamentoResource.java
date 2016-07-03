package co.com.aptamob.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import co.com.aptamob.core.api.departamento.DepartamentoApi;
import co.com.aptamob.core.api.zona.ZonaApi;
import co.com.aptamob.core.service.IDepartamentoService;
import co.com.aptamob.security.config.ApplicationConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/departamento")
@Api(value = "/departamento")
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
	@Path("all")
	@GET
	@ApiOperation(
        value = "Devuelve todos los departamentos",
        notes = "Devuelve todos los departamentos"
    )
	public Response listarDepartamentos(){
		List<DepartamentoApi> deps = departamentoS.getDepartamentos();
		return Response.ok(deps.toArray(new DepartamentoApi[deps.size()])).build();
	}
	
	@PermitAll
	@Path("{id}")
	@GET
	@ApiOperation(
        value = "Devuelve un departamento",
        notes = "Devuelve un departamento buscado por id"
    )
	public Response obtenerDepartamento(@ApiParam(value="id") @PathParam("id") String id){
		DepartamentoApi dep = departamentoS.getDepartamento(id);
		return Response.ok(dep).build();
	}
	
	@PermitAll
	@Path("{id}/zonas")
	@GET
	@ApiOperation(
        value = "Devuelve las zonas de un departamento",
        notes = "Devuelve las zonas un departamento buscado por id"
    )
	public Response listarZonasDepartamento(@ApiParam(value="id") @PathParam("id") String id){
		DepartamentoApi dep = departamentoS.getDepartamento(id);
		return Response.ok(dep.getZonas().toArray(new ZonaApi[dep.getZonas().size()])).build();
	}
}
