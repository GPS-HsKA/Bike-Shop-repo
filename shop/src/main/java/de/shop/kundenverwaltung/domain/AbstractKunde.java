package de.shop.kundenverwaltung.domain;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import de.shop.bestellverwaltung.domain.Bestellungen;

@XmlRootElement

public abstract class AbstractKunde implements Serializable

{
	/**
	 * 
	 */
	private static final long serialVersionUID = -89734504223897613L;
	private Long kunden_id;
	private String nachname;
	private String email;
	private Adresse adresse;
	
	private List<Bestellungen> Bestellliste;
	
	private URI bestellungsUri;
	
	// Getter und Setter für Attribute
	
	public Long getKunden_id() {
		return kunden_id;
	}
	public void setKunden_id(Long kunden_id) {
		this.kunden_id = kunden_id;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public URI getBestellungsUri() {
		return bestellungsUri;
	}
	public void setBestellungsUri(URI bestellungsUri) {
		this.bestellungsUri = bestellungsUri;
	}
	public List<Bestellungen> getBestellungen() {
		return Bestellliste;
	}
	public void setBestellungen(List<Bestellungen> bestellungen) {
		this.Bestellliste = bestellungen;
	}

	public URI getBestellungenUri() 
	{
		return bestellungsUri;
	}
	public void setBestellungenUri(URI bestellungenUri) 
	{
		this.bestellungsUri = bestellungenUri;
	
	}
}
