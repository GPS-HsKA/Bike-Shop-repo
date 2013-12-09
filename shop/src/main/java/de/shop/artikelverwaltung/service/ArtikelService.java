package de.shop.artikelverwaltung.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;

//import org.hibernate.validator.constraints.NotEmpty;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.interceptor.Log;
import de.shop.util.Mock;

@Dependent
@Log
public class ArtikelService implements Serializable {
	private static final long serialVersionUID = -5105686816948437276L;

	@NotNull( message = "{artikelverwaltung.artikel.notFound.id}")
	public Artikel findArtikelById(Long id) {
		// TODO id pruefen
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findArtikelbyId(id);
	}
	
	
	public Artikel createArtikel(Artikel artikel)
	{
		return Mock.createArtikel(artikel);
	}
	
	public void updateArtikel(Artikel artikel) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		Mock.updateArtikel(artikel);
	}
	
	@NotNull(message = "{artikelverwaltung.artikel.notFound.bezeichnung}")
	public List<Artikel> findArtikelByBezeichnung(String bezeichnung)
	{
		return Mock.findArtikelByBezeichnung(bezeichnung);
	}
	
	@NotNull(message = "{artikelverwaltung.artikel.notFound.artikels}")
	public List<Artikel> findAllArtikels()
	{
		return Mock.findAllArtikels();
	}
}

	
