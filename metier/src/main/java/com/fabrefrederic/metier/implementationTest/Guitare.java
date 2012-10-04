/**
 *
 * @author frederic.fabre
 *
 */
package com.fabrefrederic.metier.implementationTest;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author frederic.fabre
 *
 */

@Entity
@Table(name = "Guitare")
@Component()
public class Guitare implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -1019551874115832710L;

	/** */
	final static Logger logger = LoggerFactory.getLogger(Guitare.class);
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="musicmanager_id_seq")
    @SequenceGenerator(name="musicmanager_id_seq", sequenceName="musicmanager_id_seq", allocationSize=1)
	@Column(name = "Guitare_Id")
	private Long id;

	/** Mod�le */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name = "Guitare_ModeleId",
			unique = true,
			nullable = false,
			updatable = false)
			private Modele modele;

	/**
	 * M�thode appel�e par Spring une fois le Bean cr�� et
	 * ses d�pendances inject�es et non juste apr�s sa cr�ation
	 * Page 76
	 */
	@PostConstruct
	public void init() {
		logger.debug("Classe guitare @PostConstruct - Methode init : cr�ation du bean");
	}

	/**
	 * M�thode appel�e par Spring une fois le Bean d�truit
	 * Page 76
	 */
	@PreDestroy
	public void close() {
		logger.debug("Classe guitare @PreDestroy - Methode close : bean d�truit");
	}

	/**
	 * @return the id
	 * @category Accessor
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 * @category Accessor
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the modele
	 * @category Accessor
	 */
	public Modele getModele() {
		return this.modele;
	}

	/**
	 * @param modele the modele to set
	 * @category Accessor
	 */
	public void setModele(Modele modele) {
		this.modele = modele;
	}

}