package de.shop.bestellverwaltung.domain;

import static de.shop.util.Constants.KEINE_ID;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Logger;

import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.util.persistence.AbstractAuditable;

@XmlRootElement
@Entity

@Table (indexes = {
		@Index (columnList = "kunde_fk"),
		@Index (columnList = "erzeugt")
})
@NamedQueries({
	@NamedQuery(name  = Bestellung.FIND_BESTELLUNGEN_BY_KUNDE,
                query = "SELECT b"
			            + " FROM   Bestellung b"
						+ " WHERE  b.kunde = :" + Bestellung.PARAM_KUNDE),
	@NamedQuery(name  = Bestellung.FIND_KUNDE_BY_ID,
 			    query = "SELECT b.kunde"
                        + " FROM   Bestellung b"
  			            + " WHERE  b.id = :" + Bestellung.PARAM_ID)
})

public class Bestellung extends AbstractAuditable {
	private static final long serialVersionUID = 1618359234119003714L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final String PREFIX = "Bestellung.";
	public static final String FIND_BESTELLUNGEN_BY_KUNDE = PREFIX + "findBestellungenByKunde";
	public static final String FIND_KUNDE_BY_ID = PREFIX + "findBestellungKundeById";
	
	public static final String PARAM_KUNDE = "kunde";
	public static final String PARAM_ID = "id";
	
	public static final String GRAPH_LIEFERUNGEN = PREFIX + "lieferungen";
	
	@Id
	@GeneratedValue
	@Basic(optional = false)
	private Long id = KEINE_ID;
	
	@ManyToOne
	@JoinColumn(name = "kunde_fk", nullable = false, insertable = false, updatable = false)
	@XmlTransient
	private AbstractKunde kunde;
	
	@Transient
	private URI kundeUri;
	
	@OneToMany(fetch = EAGER, cascade = { PERSIST, REMOVE })
	@JoinColumn(name = "bestellung_fk", nullable = false)
	@NotEmpty(message = "{bestellverwaltung.bestellung.bestellpositionen.notEmpty}")
	@Valid
	private Set<Bestellposition> bestellpositionen;
	
	@XmlElement
	public Date getDatum() {
		return getErzeugt();
	}
	
	public void setDatum(Date datum) {
		setErzeugt(datum);
	}

	public Bestellung() {
		super();
	}
	
	public Bestellung(Set<Bestellposition> bestellpositionen) {
		super();
		this.bestellpositionen = bestellpositionen;
	}
	
	@PostPersist
	private void postPersist() {
		LOGGER.debugf("Neue Bestellung mit ID=%d", id);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Set<Bestellposition> getBestellpositionen() {
		if (bestellpositionen == null) {
			return null;
		}
		
		return Collections.unmodifiableSet(bestellpositionen);
	}
	
	public void setBestellpositionen(Set<Bestellposition> bestellpositionen) {
		if (this.bestellpositionen == null) {
			this.bestellpositionen = bestellpositionen;
			return;
		}
		
		// Wiederverwendung der vorhandenen Collection
		this.bestellpositionen.clear();
		if (bestellpositionen != null) {
			this.bestellpositionen.addAll(bestellpositionen);
		}
	}
	
	public Bestellung addBestellposition(Bestellposition bestellposition) {
		if (bestellpositionen == null) {
			bestellpositionen = new HashSet<>();
		}
		bestellpositionen.add(bestellposition);
		return this;
	}

	public AbstractKunde getKunde() {
		return kunde;
	}
	public void setKunde(AbstractKunde kunde) {
		this.kunde = kunde;
	}

	public URI getKundeUri() {
		return kundeUri;
	}

	public void setKundeUri(URI kundeUri) {
		this.kundeUri = kundeUri;
	}
	
	@Override
	public String toString() {
		final Long kundeId = kunde == null ? null : kunde.getId();
		return "Bestellung [id=" + id + ", kundeId=" + kundeId + ", kundeUri=" + kundeUri
				+ ", " + super.toString() + ']';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
		result = prime * result + ((getErzeugt() == null) ? 0 : getErzeugt().hashCode());
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
		final Bestellung other = (Bestellung) obj;
		
		if (kunde == null) {
			if (other.kunde != null) {
				return false;
			}
		}
		else if (!kunde.equals(other.kunde)) {
			return false;
		}
		
		if (getErzeugt() == null) {
			if (other.getErzeugt() != null) {
				return false;
			}
		}
		else if (!getErzeugt().equals(other.getErzeugt())) {
			return false;
		}
		
		return true;
	}
}
