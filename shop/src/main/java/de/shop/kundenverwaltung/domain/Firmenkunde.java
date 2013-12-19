package de.shop.kundenverwaltung.domain;

import static de.shop.kundenverwaltung.domain.AbstractKunde.FIRMENKUNDE;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Cacheable
@DiscriminatorValue(FIRMENKUNDE)
public class Firmenkunde extends AbstractKunde {
	private static final long serialVersionUID = 6258156986876418100L;
}
