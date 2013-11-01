package de.shop.artikelverwaltung.domain;


import java.io.Serializable;
//import java.net.URI;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Artikel implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	private double preis;
	private String name;
	private String beschreibeung;
	private int artikelnummer;
	private List<Artikel> zubehoer;	
	
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibeung() {
		return beschreibeung;
	}
	public void setBeschreibeung(String beschreibeung) {
		this.beschreibeung = beschreibeung;
	}
	public int getArtikelnummer() {
		return artikelnummer;
	}
	public void setArtikelnummer(int artikelnummer) {
		this.artikelnummer = artikelnummer;
	}
	public List<Artikel> getZubehoer() {
		return zubehoer;
	}
	public void setZubehoer(List<Artikel> zubehoer) {
		this.zubehoer = zubehoer;
	}
	
}
