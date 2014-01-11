package de.shop.kundenverwaltung.domain;

import static de.shop.kundenverwaltung.domain.AbstractKunde.PRIVATKUNDE;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@DiscriminatorValue(PRIVATKUNDE)
@Cacheable
public class Privatkunde extends AbstractKunde {
	private static final long serialVersionUID = 133152931415808605L;
}
