package co.com.aptamob.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import co.com.aptamob.core.api.FotoApi;
import co.com.aptamob.core.service.IFotoService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.io.InputStream;
import java.net.URI;
import java.util.List;

@Path("/foto")
@Component
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
public class FotoResource {
	
	@Autowired
	private IFotoService fotoS;
	
	@Context
    protected UriInfo uriInfo;
	
	@PermitAll
	@POST
	@Path("/album/{id_album}")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response crearFoto(@FormDataParam("file") InputStream archivo,
							  @PathParam("id_album") String idAlbum){
		
		FotoApi fot = fotoS.createFoto(idAlbum, archivo);
		URI loc = uriInfo.getAbsolutePathBuilder().path(fot.getId()).build();
		return Response.created(loc).entity(fot).build();
	}

}
