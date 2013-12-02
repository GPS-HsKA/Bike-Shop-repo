package de.shop.bestellverwaltung.domain;

import static de.shop.util.Constants.KEINE_ID;

import java.io.Serializable;
import java.net.URI;

//TODO KAPITEL 5
//import javax.persistence.PostPersist;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
import javax.validation.constraints.Min;

import de.shop.artikelverwaltung.domain.Artikel;


public class Bestellposition implements Serializable {
	private static final long serialVersionUID = 892583057771741519L;
	private static final int ANZAHL_MIN = 1;
	
	private Long id = KEINE_ID;
	
	@XmlTransient
	private Artikel artikel;
	
	@Transient
	private URI artikelUri;
	
	@Min(value = ANZAHL_MIN, message = "{bestellposition.anzahl.min}")
	private short anzahl;
	
	public Bestellposition() {
		super();
	}
	
	public Bestellposition(Artikel artikel) {
		super();
		this.artikel = artikel;
		this.anzahl = 1;
	}
	
	public Bestellposition(Artikel artikel, short anzahl) {
		super();
		this.artikel = artikel;
		this.anzahl = anzahl;
	}
	
	//TODO KAPITEL 5
//	@PostPersist
//	private void postPersist() {
//		LOGGER.debugf("Neue Bestellposition mit ID=%d", id);
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public URI getArtikelUri() {
		return artikelUri;
	}

	public void setArtikelUri(URI artikelUri) {
		this.artikelUri = artikelUri;
	}

	public short getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(short anzahl) {
		this.anzahl = anzahl;
	}

	@Override
	public String toString() {
		return "Bestellposition [id=" + id + ", artikelUri=" + artikelUri
				+ ", anzahl=" + anzahl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anzahl;
		result = prime * result + ((artikel == null) ? 0 : artikel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Bestellposition other = (Bestellposition) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		}
		else if (!id.equals(other.id)) {
			return false;
		}
		if (artikel == null) {
			if (other.artikel != null) {
				return false;
			}
		}
		else if (!artikel.equals(other.artikel)) {
			return false;
		}
		
		return true;
	}

}
