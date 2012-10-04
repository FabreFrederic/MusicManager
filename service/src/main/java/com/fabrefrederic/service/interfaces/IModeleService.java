package com.fabrefrederic.service.interfaces;

import java.util.List;

import org.springframework.context.ApplicationEventPublisherAware;

import com.fabrefrederic.metier.implementationTest.Marque;
import com.fabrefrederic.metier.implementationTest.Modele;

/**
 *
 * @author frederic.fabre
 *
 */
public interface IModeleService {

	/**
	 * Retourne la liste des mod�les de la marque choisie
	 */
	public List<Modele> findListeModelesByMarque(Marque marque);

	/**
	 * Sauvegarde ou met � jour un mod�le
	 * @param object : objet � sauvegarder ou � mettre � jour
	 */
	public void save(Modele modele);
}
