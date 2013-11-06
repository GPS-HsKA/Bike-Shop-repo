package de.shop.artikelverwaltung.rest;

import static de.shop.util.Constants.SELF_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.shop.util.Mock;
import de.shop.util.rest.UriHelper;
import de.shop.util.rest.NotFoundException;
import de.shop.artikelverwaltung.domain.Artikel;

@Path("/artikel")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
public class ArtikelRecource {
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private UriHelper uriHelper;
	
	@Inject
	private ArtikelRecource artikelResource;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findArtikelById(@PathParam("id") Long id) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		final Artikel artikel = Mock.findArtikelbyId(id);
		if (artikel == null) {
			throw new NotFoundException("Kein Artikel mit der ID " + id + " gefunden.");
		}
		
		setStructuralLinks(artikel, uriInfo);
		
		// Link-Header setzen
		final Response response = Response.ok(artikel)
                                          .links(getTransitionalLinks(artikel, uriInfo))
                                          .build();
		
		return response;
	}
	
	
	public void setStructuralLinks(Artikel artikel, UriInfo uriInfo) {
		// URI fuer Zubehoer setzen
		final Artikel zubehoer = artikel.getZubehoer();
		if (zubehoer != null) {
			final URI zubehoerUri = artikelResource.getUriZubehoer(artikel.getZubehoer(), uriInfo);
			artikel.setZubehoerUri(zubehoerUri);
		}
	}
	
	private Link[] getTransitionalLinks(Artikel artikel, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriZubehoer(artikel, uriInfo))
                              .rel(SELF_LINK)
                              .build();
		return new Link[] { self };
	}
	
	public URI getUriZubehoer(Artikel bestellung, UriInfo uriInfo) {
		return uriHelper.getUri(ArtikelRecource.class, "findArtikelById", bestellung.getId(), uriInfo);
	}

}
