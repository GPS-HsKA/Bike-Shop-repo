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
//import de.shop.util.interceptor.Log;
import de.shop.util.Mock;

// FIXME nur der Anfang

//@Log
public class BestellungServiceImpl implements BestellungService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2550161482460410931L;
	
	//private static final Logger LOGGER = 

	@Override
	public Bestellung findBestellungbyId(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bestellung createBestellung(Bestellung bestellung,
			AbstractKunde kunde, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
