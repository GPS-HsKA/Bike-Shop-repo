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
// Familienstand & Geschlecht	
//	@Column(length = 2)
//	//@Convert(converter = FamilienstandTypeConverter.class)
//	private FamilienstandType familienstand = FamilienstandType.VERHEIRATET;
//	
//	@Column(length = 1)
//	private GeschlechtType geschlecht = GeschlechtType.WEIBLICH;
//	public FamilienstandType getFamilienstand() {
//		return familienstand;
//	}
//	public void setFamilienstand(FamilienstandType familienstand) {
//		this.familienstand = familienstand;
//	}
//
//	public GeschlechtType getGeschlecht() {
//		return geschlecht;
//	}
//	public void setGeschlecht(GeschlechtType geschlecht) {
//		this.geschlecht = geschlecht;
//	}
//
//	@Override
//	public String toString() {
//		return "Privatkunde [" + super.toString() + ", familienstand=" + familienstand
//			   + ", geschlecht=" + geschlecht + ']';
//	}
}
