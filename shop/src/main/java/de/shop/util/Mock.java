package de.shop.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;




import java.util.Set;
import java.util.TreeSet;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.bestellverwaltung.domain.Bestellposition;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.kundenverwaltung.domain.Adresse;
import de.shop.kundenverwaltung.domain.Firmenkunde;
//import de.shop.kundenverwaltung.domain.HobbyType;
import de.shop.kundenverwaltung.domain.Privatkunde;

/**
 * Emulation des Anwendungskerns
 */
public final class Mock {
	private static final int MAX_ID = 99;
	private static final int MAX_KUNDEN = 8;
	private static final int MAX_BESTELLUNGEN = 4;
	private static final int JAHR = 2001;
	private static final int MONAT = 0;
	private static final int TAG = 31; 
	

	public static AbstractKunde findKundeById(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		
		final AbstractKunde kunde = id % 2 == 1 ? new Privatkunde() : new Firmenkunde();
		kunde.setId(id);
		kunde.setNachname("Nachname");
		kunde.setEmail("" + id + "@hska.de");
		
		final Adresse adresse = new Adresse();
		adresse.setId(id + 1);        // andere ID fuer die Adresse
		adresse.setPlz("12345");
		adresse.setOrt("Testort");
		adresse.setKunde(kunde);
		kunde.setAdresse(adresse);
		
//		if (kunde.getClass().equals(Privatkunde.class)) {
			//TODO Hobbies
//			final Privatkunde privatkunde = (Privatkunde) kunde;
//			final Set<HobbyType> hobbies = new HashSet<>();
//			hobbies.add(HobbyType.LESEN);
//			hobbies.add(HobbyType.REISEN);
//			privatkunde.setHobbies(hobbies);
//		}
		
		return kunde;
	}

	public static List<AbstractKunde> findAllKunden() {
		final int anzahl = MAX_KUNDEN;
		final List<AbstractKunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final AbstractKunde kunde = findKundeById(Long.valueOf(i));
			kunden.add(kunde);			
		}
		return kunden;
	}

	public static List<AbstractKunde> findKundenByNachname(String nachname) {
		final int anzahl = nachname.length();
		final List<AbstractKunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final AbstractKunde kunde = findKundeById(Long.valueOf(i));
			kunde.setNachname(nachname);
			kunden.add(kunde);			
		}
		return kunden;
	}
	

	public static List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// Beziehungsgeflecht zwischen Kunde und Bestellungen aufbauen
		final int anzahl = kunde.getId().intValue() % MAX_BESTELLUNGEN + 1;  // 1, 2, 3 oder 4 Bestellungen
		final List<Bestellung> bestellungen = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Bestellung bestellung = findBestellungById(Long.valueOf(i));
			bestellung.setKunde(kunde);
			bestellungen.add(bestellung);			
		}
		kunde.setBestellungen(bestellungen);
		
		return bestellungen;
	}

	public static Bestellung findBestellungById(Long id) {
		if (id > MAX_ID) {
			return null;
		}

		final AbstractKunde kunde = findKundeById(id + 1);  // andere ID fuer den Kunden

		final Bestellung bestellung = new Bestellung();
		bestellung.setId(id);
//		bestellung.setBestellposition(createBestellpositionen(bestellung));
		bestellung.setKunde(kunde);
		bestellung.setBestellpositionen(createBestellpositionen(bestellung));		
		
		return bestellung;
	}

	public static <T extends AbstractKunde> T createKunde(T kunde) {
		// Neue IDs fuer Kunde und zugehoerige Adresse
		// Ein neuer Kunde hat auch keine Bestellungen
		final String nachname = kunde.getNachname();
		kunde.setId(Long.valueOf(nachname.length()));
		final Adresse adresse = kunde.getAdresse();
		adresse.setId((Long.valueOf(nachname.length())) + 1);
		adresse.setKunde(kunde);
		kunde.setBestellungen(null);
		
		System.out.println("Neuer Kunde: " + kunde);
		return kunde;
	}

	public static Set<Bestellposition> createBestellpositionen(Bestellung bestellung)
	{
		final short anzahl = 3;
		final long aId = 1;
		final long bId = 1;
		final Artikel art = new Artikel();
		art.setId(aId);
		art.setBezeichnung("Sau gutes Produkt");
		art.setBeschreibung("Dieses Produkt ist einfach nur geil!!!");
		art.setPreis(0.99);
		art.setVerfuegbar(true);
		final Bestellposition bestellpositionen = new Bestellposition(art, anzahl);
		final Set<Bestellposition> bestellpositionenliste = new TreeSet<Bestellposition>();
		bestellpositionenliste.add(bestellpositionen);
		
		return bestellpositionenliste;
	}
		

	public static void updateKunde(AbstractKunde kunde) {
		System.out.println("Aktualisierter Kunde: " + kunde);
	}

	public static void deleteKunde(Long kundeId) {
		System.out.println("Kunde mit ID=" + kundeId + " geloescht");
	}

	private Mock() { /**/ }

	public static Artikel findArtikelbyId(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		// TODO Auto-generated method stub
		// 0.99 als Konstante angeben!
		final double testwert = 0.99;
		// FIXME unnötig
//		final Artikel zub = new Artikel();
//		zub.setBezeichnung("Sau gutes Produkt");
//		zub.setBeschreibung("Dieses Produkt ist einfach nur geil!!!");
//		zub.setPreis(0.99);
//		zub.setId(id);
//		zub.setVerfuegbar(true);
		
		final Artikel art = new Artikel();
		art.setId(id);
		art.setBezeichnung("Bezeichnung" + id);
		art.setBeschreibung("Dieses Produkt ist einfach nur geil!!!");
		art.setPreis(testwert);
		art.setVerfuegbar(true);
		
		return art;
		
	}
	
	public static List<Artikel> findAllArtikels() {
		final int anzahl = MAX_KUNDEN;
		final List<Artikel> artikels = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Artikel artikel = findArtikelbyId(Long.valueOf(i));
			artikels.add(artikel);			
		}
		return artikels;
	}
	
	public static Artikel createArtikel(Artikel artikel) {
		// Neue IDs fuer Artikel
		final String bezeichnung = artikel.getBezeichnung();
		artikel.setId(Long.valueOf(bezeichnung.length()));
		
		System.out.println("Neuer Artikel: " + artikel);
		return artikel;
	}
	
	public static List<Artikel> findArtikelByBezeichnung(String bezeichnung) {
		final int anzahl = bezeichnung.length();
		final List<Artikel> artikels = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Artikel artikel = findArtikelbyId(Long.valueOf(i));
			artikel.setBezeichnung(bezeichnung);
			artikels.add(artikel);			
		}
		return artikels;
	}
	
	public static Bestellung createBestellung(Bestellung bestellung, AbstractKunde kunde) {
		// Neue IDs fuer Artikel
		final String nachname = kunde.getNachname().toString();
		bestellung.setId(Long.valueOf(nachname.length()));
		
		System.out.println("Neue Bestellung: " + bestellung);
		return bestellung;
	}
	
	public static void updateArtikel(Artikel artikel) {
		System.out.println("Aktualisierter Kunde: " + artikel);
	}
	
	public static AbstractKunde findKundeByEmail(String email) {
		if (email.startsWith("x")) {
			return null;
		}
		
		final AbstractKunde kunde = email.length() % 2 == 1 ? new Privatkunde() : new Firmenkunde();
		kunde.setId(Long.valueOf(email.length()));
		kunde.setNachname("Nachname");
		kunde.setEmail(email);
		final GregorianCalendar seitCal = new GregorianCalendar(JAHR, MONAT, TAG);
		final Date seit = seitCal.getTime();
		kunde.setSeit(seit);
		
		final Adresse adresse = new Adresse();
		adresse.setId(kunde.getId() + 1);        // andere ID fuer die Adresse
		adresse.setPlz("12345");
		adresse.setOrt("Testort");
		adresse.setKunde(kunde);
		kunde.setAdresse(adresse);
		
		if (kunde.getClass().equals(Privatkunde.class)) {
			final Privatkunde privatkunde = (Privatkunde) kunde;
			/* final Set<HobbyType> hobbies = new HashSet<>();
			hobbies.add(HobbyType.LESEN);
			hobbies.add(HobbyType.REISEN);
			privatkunde.setHobbies(hobbies);
			*/
		}
		
		return kunde;
	}
}
