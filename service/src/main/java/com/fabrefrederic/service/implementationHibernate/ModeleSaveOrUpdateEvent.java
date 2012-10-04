package com.fabrefrederic.service.implementationHibernate;

import org.springframework.context.ApplicationEvent;

import com.fabrefrederic.metier.implementationTest.Modele;

public class ModeleSaveOrUpdateEvent extends ApplicationEvent {

	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;
	/** Modele */
	private final Modele modele;

	/**
	 *
	 * @param source
	 * @param modeleSavedOrUpdated modele nouvellement cr�� ou updat�
	 * @category Constructor
	 */
	public ModeleSaveOrUpdateEvent(Object source, Modele modeleSavedOrUpdated) {
		super(source);
		// Stocke le modele dans l'�v�nement
		this.modele = modeleSavedOrUpdated;
	}

	/**
	 * Accesseur du modele pour que les consommateurs puissent y acc�der
	 * @return the modele
	 * @category Accessor
	 */
	public Modele getModele() {
		return this.modele;
	}



}
