package de.shop.bestellverwaltung.service;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.util.interceptor.Log;
import de.shop.util.Mock;

@Log
public class BestellungServiceImpl implements BestellungService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2550161482460410931L;
	
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@Inject
	@NeueBestellung
	private transient Event<Bestellung> event;

	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}
	
	@Override
	public Bestellung findBestellungbyId(Long Id) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findBestellungById(Id);
	}

	@Override
	public List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findBestellungenByKunde(kunde);
	}

	@Override
	public Bestellung createBestellung(Bestellung bestellung,
			AbstractKunde kunde, Locale locale) {
		// TODO Datenbanzugriffsschicht statt Mock 
		// FIXME Mock.createBestellung umschreiben
		//		bestellung = Mock.createBestellung(bestellung, kunde);
				event.fire(bestellung);
				
				return bestellung;
	}
	

}
