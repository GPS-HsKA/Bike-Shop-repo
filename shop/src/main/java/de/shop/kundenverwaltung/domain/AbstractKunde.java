package de.shop.kundenverwaltung.domain;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import de.shop.bestellverwaltung.domain.Bestellung;

@XmlRootElement
@XmlSeeAlso({ Firmenkunde.class, Privatkunde.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
/*@JsonSubTypes({
@Type(value = Privatkunde.class, name = AbstractKunde.PRIVATKUNDE),
@Type(value = Firmenkunde.class, name = AbstractKunde.FIRMENKUNDE) })*/
public abstract class AbstractKunde implements Serializable

{
	/**
	 * 
	 */
	
	public static final String PRIVATKUNDE = "P";
	public static final String FIRMENKUNDE = "F";
	
	private static final long serialVersionUID = -89734504223897613L;
	private Long kundenId;
	private String nachname;
	private String email;
	private Adresse adresse;
	
	private List<Bestellung> Bestellliste;
	
	private URI bestellungsUri;
	
	// Getter und Setter für Attribute
	
	public Long getKundenId() {
		return kundenId;
	}
	public void setKundenId(Long kundenId) {
		this.kundenId = kundenId;
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
	public List<Bestellung> getBestellungen() {
		return Bestellliste;
	}
	public void setBestellungen(List<Bestellung> bestellungen) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractKunde other = (AbstractKunde) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AbstractKunde [id=" + kundenId + ", nachname=" + nachname + ", email=" + email
			   + ", bestellungenUri=" + bestellungsUri + "]";
	}
}
