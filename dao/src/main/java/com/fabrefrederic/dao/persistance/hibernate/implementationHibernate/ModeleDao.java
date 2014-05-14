/**
 *
 */
package com.fabrefrederic.dao.persistance.hibernate.implementationHibernate;

import com.fabrefrederic.metier.implementationTest.Modele;

/**
 * @author Frederic Fabre
 *
 */
public class ModeleDao extends GenericJpaDao<Modele> {

	/**
	 * Constructor
	 *
	 * @param persistentClass
	 */
	public ModeleDao(Class<Modele> persistentClass) {
		super(persistentClass);
	}

}
