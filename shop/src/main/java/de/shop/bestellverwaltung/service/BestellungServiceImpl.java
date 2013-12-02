package de.shop.bestellverwaltung.service;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jboss.logging.Logger;

import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.util.interceptor.Log;
import de.shop.util.Mock;

@Dependent
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
	@NotNull(message = "{bestellung.notFound.id}")
	public Bestellung findBestellungById(Long id) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findBestellungById(id);
	}

	@Override
	@Size(min = 1, message = "{bestellung.notFound.kunde}")
	public List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findBestellungenByKunde(kunde);
	}

	@Override
	public Bestellung createBestellung(Bestellung bestellung,
			AbstractKunde kunde, Locale locale) {
		// TODO Datenbanzugriffsschicht statt Mock 
		bestellung = Mock.createBestellung(bestellung, kunde);
		event.fire(bestellung);
				
		return bestellung;
	}
	

}
