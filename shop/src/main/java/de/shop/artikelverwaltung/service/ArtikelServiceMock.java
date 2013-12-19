package de.shop.artikelverwaltung.service;

import javax.enterprise.context.Dependent;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.cdi.MockService;
import de.shop.util.interceptor.Log;


@MockService
@Dependent
@Log
public class ArtikelServiceMock extends ArtikelService {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5302107556277473090L;

	@Override
	public Artikel findArtikelById(Long id) {
		final Artikel artikel = new Artikel();
		artikel.setId(id);
		artikel.setBezeichnung("Bezeichnung" + id);
		return artikel;
	}
}
