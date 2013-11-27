package de.shop.kundenverwaltung.service;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.util.Mock;

public class KundeService implements Serializable {
	private static final long serialVersionUID = 4360325837484294309L;
	
	@NotNull(message = "{kunde.notFound.id}")
	public AbstractKunde findKundeByID(Long id) {
		if(id == null)
			return null;
		//TODO Datenbankzugriff muss noch gemacht werden
		return Mock.findKundeById(id);
	
	}
//TODO findKundeByEmail schreiben	
//	@NotNull(message = "{kunde.NotFound.id}")
//	public AbstractKunde findKundebyEmail(String email) {
//		if(email == null)
//			return null;
//TODO Datenbankzugriff muss noch gemacht werden
//		return Mock.findKundeByEmail(email);
//	}
	
	public List<AbstractKunde> findAllKunde(){
		//TODO Datenbankzugriff muss noch gemacht werden
		return Mock.findAllKunden();
	}
	
	@Size(min = 1, message = "{kunde.notFound.nachname}")
	public List<AbstractKunde> findKundeByNachname(String nachname) {
		//TODO Datenbankzugriff muss noch gemacht werden
		return Mock.findKundenByNachname(nachname);
	}
	
	public void deleteKunde(Long id) {
		AbstractKunde neuerKunde = findKundeByID(id);
		if(neuerKunde == null)
			return;
		//TODO KundeDeleteBestellungException muss noch geschrieben werden
//		if(!neuerKunde.getBestellungen().isEmpty()) {
//			throw new KundeDeleteBestellungException(neuerKunde);
//		}
	////TODO Datenbankzugriff muss noch gemacht werden
		Mock.deleteKunde(neuerKunde.getId());
	}
}
