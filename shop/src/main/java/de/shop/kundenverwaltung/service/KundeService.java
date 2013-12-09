package de.shop.kundenverwaltung.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.util.Mock;
import de.shop.util.interceptor.Log;

@Dependent
@Log
public class KundeService implements Serializable {
	private static final long serialVersionUID = 4360325837484294309L;
	
	@NotNull(message = "{kundenverwaltung.kunde.notFound.id}")
	public AbstractKunde findKundeByID(Long id) {
		if(id == null)
			return null;
		//TODO Datenbankzugriff muss noch gemacht werden
		return Mock.findKundeById(id);
	
	}

	@NotNull(message = "{kundenverwaltung.kunde.notFound.id}")
	public AbstractKunde findKundebyEmail(String email) {
		if(email == null)
			return null;
		//TODO Datenbankzugriff muss noch gemacht werden
		return Mock.findKundeByEmail(email);
	}
	@Size(min = 1, message = "{kundenverwaltung.kunde.notFound.alleKunden}")
	public List<AbstractKunde> findAllKunde(){
		//TODO Datenbankzugriff muss noch gemacht werden
		return Mock.findAllKunden();
	}
	
	@Size(min = 1, message = "{kundenverwaltung.kunde.notFound.nachname}")
	public List<AbstractKunde> findKundeByNachname(String nachname) {
		//TODO Datenbankzugriff muss noch gemacht werden
		return Mock.findKundenByNachname(nachname);
	}
	
	public void deleteKunde(Long id) {
		AbstractKunde neuerKunde = findKundeByID(id);
		if(neuerKunde == null)
			return;
		if(!neuerKunde.getBestellungen().isEmpty()) {
			throw new KundeDeleteBestellungException(neuerKunde);
		}
		//TODO Datenbankzugriff muss noch gemacht werden
		Mock.deleteKunde(neuerKunde.getId());
	}

	//FIXME Funktion returned null, da ein Konflikt zwischen T und AbstractKunde besteht
	public <T extends AbstractKunde> T createKunde(T kunde) {
		if (kunde == null) {
			return kunde;
		}

		final AbstractKunde tmp = findKundebyEmail(kunde.getEmail());  // Kein Aufruf als Business-Methode
		if (tmp == null) {
			throw new EmailExistsException(kunde.getEmail());
		}
		// TODO Datenbanzugriffsschicht statt Mock
		kunde = Mock.createKunde(kunde);

		return kunde;
	}
	
	
	public <T extends AbstractKunde> T updateKunde(T kunde) {
		if (kunde == null) {
			return null;
		}

		// Pruefung, ob die Email-Adresse schon existiert
		final AbstractKunde vorhandenerKunde = findKundebyEmail(kunde.getEmail());  // Kein Aufruf als Business-Methode
		if (vorhandenerKunde != null) {
			// Gibt es die Email-Adresse bei einem anderen, bereits vorhandenen Kunden?
			if (vorhandenerKunde.getId().longValue() != kunde.getId().longValue()) {
				throw new EmailExistsException(kunde.getEmail());
			}
		}

		// TODO Datenbanzugriffsschicht statt Mock
		Mock.updateKunde(kunde);
		
		return kunde;
	}
}
