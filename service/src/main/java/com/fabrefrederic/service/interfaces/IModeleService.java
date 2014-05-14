package com.fabrefrederic.service.interfaces;

import java.util.List;

import org.springframework.context.ApplicationEventPublisherAware;

import com.fabrefrederic.metier.implementationTest.Marque;
import com.fabrefrederic.metier.implementationTest.Modele;

/**
 * Modele Service
 *
 * @author frederic.fabre
 *
 */
public interface IModeleService {

	/**
	 *
	 */
	public List<Modele> findListeModelesByMarque(Marque marque);

	/**
	 *
	 * @param object :
	 */
	public void save(Modele modele);
}
