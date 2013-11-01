package de.shop.artikelverwaltung.rest;


//import static de.shop.util.Constants.SELF_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.shop.util.rest.UriHelper;
import de.shop.util.rest.NotFoundException;

@Path("/Artikel")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
public class ArtikelResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private UriHelper uriHelper;
	
	@Inject
	private ArtikelResource ArtikelResource;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response ArtikelById(@PathParam("id") Integer id) {
		
		if (id == null )
		{
			// TODO Exception 
		}
		// TODO implementierung 
		final Response response = Response.ok()
                                          .build();
		
		return response;
	}
	
	@GET
	@Path("{id:[1-9][0-9]*}/zub")
	public Response ZubehoerListeById(@PathParam("id") Long id) {
		
	}
	}
	
	
//	@DELETE
//	@Path("{id:[1-9][0-9]*}/del")
//	public Response DeleteArtikelById(@PathParam("id") Long id) {
//	
//		// TODO implementierung
//		final Response responce = Response.ok().build();
//		
//		return responce;
//	}

	
	
}
