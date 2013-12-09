package de.shop.artikelverwaltung.rest;

import static de.shop.util.Constants.FIRST_LINK;
import static de.shop.util.Constants.LAST_LINK;
import static de.shop.util.Constants.SELF_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.artikelverwaltung.service.ArtikelService;
import de.shop.artikelverwaltung.service.ArtikelServiceMock;
import de.shop.util.Mock;
import de.shop.util.interceptor.Log;
import de.shop.util.rest.UriHelper;

@Path("/artikel")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
@Log
@RequestScoped
public class ArtikelResource {
//	private static final String NOT_FOUND_ID = "artikel.notFound.id";
	public static final String ARTIKEL_BEZEICHNUNG_QUERY_PARAM = "Bezeichnung";
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private ArtikelService as;
	
	@Inject
	private UriHelper uriHelper;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findArtikelById(@PathParam("id") Long id) {
		final Artikel artikel = as.findArtikelById(id);

		
		setStructuralLinks(artikel, uriInfo);
		
		// Link-Header setzen
		final Response response = Response.ok(artikel)
                                          .links(getTransitionalLinks(artikel, uriInfo))
                                          .build();
		
		return response;
	}
	
	@POST
	@Consumes({APPLICATION_JSON, APPLICATION_XML, TEXT_XML})
	@Produces
	public Response createArtikel(@Valid Artikel artikel) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
			artikel = as.createArtikel(artikel);
		return Response.created(getUriArtikel(artikel, uriInfo))
			           .build();
	}
	
	@PUT
	@Consumes({APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void updateArtikel(@Valid Artikel artikel) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		as.updateArtikel(artikel);
	}
	
	public void setStructuralLinks(Artikel artikel, UriInfo uriInfo) {
		
	}
	
	@GET
	public Response findArtikelByBezeichnung(@QueryParam(ARTIKEL_BEZEICHNUNG_QUERY_PARAM) 
		@Size(min = 3, max = 20, message = "{artikel.validation.bezeichnung}")
		String bezeichnung) {
		
		List<? extends Artikel> artikels = null;
		if (bezeichnung != null) {
			// TODO Anwendungskern statt Mock, Verwendung von Locale
			artikels = as.findArtikelByBezeichnung(bezeichnung);
		}
		else {
			// TODO Anwendungskern statt Mock, Verwendung von Locale
			artikels = as.findAllArtikels();
		}
		
		for (Artikel a : artikels) {
			setStructuralLinks(a, uriInfo);
		}
		
		return Response.ok(new GenericEntity<List<? extends Artikel>>(artikels) { })
                       .links(getTransitionalLinksArtikels(artikels, uriInfo))
                       .build();
	}
	
	private Link[] getTransitionalLinksArtikels(List<? extends Artikel> artikels, UriInfo uriInfo) {
		if (artikels == null || artikels.isEmpty()) {
			return null;
		}
		
		final Link first = Link.fromUri(getUriArtikel(artikels.get(0), uriInfo))
	                           .rel(FIRST_LINK)
	                           .build();
		final int lastPos = artikels.size() - 1;
		final Link last = Link.fromUri(getUriArtikel(artikels.get(lastPos), uriInfo))
                              .rel(LAST_LINK)
                              .build();
		
		return new Link[] {first, last};
	}
	
	private Link[] getTransitionalLinks(Artikel artikel, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriZubehoer(artikel, uriInfo))
                              .rel(SELF_LINK)
                              .build();
		return new Link[] {self};
	}
	
	public URI getUriZubehoer(Artikel bestellung, UriInfo uriInfo) {
		return uriHelper.getUri(ArtikelResource.class, "findArtikelById", bestellung.getId(), uriInfo);
	}
	
	public URI getUriArtikel(Artikel artikel, UriInfo uriInfo) {
		return uriHelper.getUri(ArtikelResource.class, "findArtikelById", artikel.getId(), uriInfo);
	}

}
