package de.shop.artikelverwaltung.domain;


import java.io.Serializable;
//import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Artikel implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double _preis;
	private String _name;
	private String _beschreibeung;
	private int _artikelnummer;
	public double get_preis() {
		return _preis;
	}
	public void set_preis(double _preis) {
		this._preis = _preis;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_beschreibeung() {
		return _beschreibeung;
	}
	public void set_beschreibeung(String _beschreibeung) {
		this._beschreibeung = _beschreibeung;
	}
	public int get_artikelnummer() {
		return _artikelnummer;
	}
	public void set_artikelnummer(int _artikelnummer) {
		this._artikelnummer = _artikelnummer;
	}
	
	
	
}
