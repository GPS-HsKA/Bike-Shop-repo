package de.shop.artikelverwaltung.domain;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Artikel implements Serializable {
	
	private static final long serialVersionUID = 456456546L;
	
	private Long id;
	private String bezeichnung;
	private double preis;
	private boolean verfuegbar;
	private String beschreibung;
	@XmlTransient
	private Artikel zubehoer;
	private URI zubehoerUri;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public boolean isVerfuegbar() {
		return verfuegbar;
	}
	public void setVerfuegbar(boolean verfuegbar) {
		this.verfuegbar = verfuegbar;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public URI getZubehoerUri() {
		return zubehoerUri;
	}
	public void setZubehoerUri(URI zubehoerUri) {
		this.zubehoerUri = zubehoerUri;
	}
	public Artikel getZubehoer(){
		return this.zubehoer;
	}
	public void setZubehoer(Artikel zubehoer){
		this.zubehoer = zubehoer;
	}
}
