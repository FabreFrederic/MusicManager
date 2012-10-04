/**
 *
 */
package com.fabrefrederic.service.implementationHibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fabrefrederic.dao.persistance.hibernate.implementationHibernate.GenericJpaDao;
import com.fabrefrederic.dao.persistance.hibernate.implementationHibernate.ModeleDao;
import com.fabrefrederic.metier.implementationTest.Marque;
import com.fabrefrederic.metier.implementationTest.Modele;
import com.fabrefrederic.service.interfaces.IModeleService;

/**
 * @author frederic.fabre
 *
 */
public class ModeleService implements IModeleService, ApplicationEventPublisherAware {
	/** */
	private GenericJpaDao<Modele> modeleDao;

	/** Publisher d'�v�nement*/
	private ApplicationEventPublisher applicationEventPublisher;

	/**
	 * Constructeur
	 */
	public ModeleService() {

	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see com.hibernateMaven01.service.interfaces.IModeleService#
	 * recupererListeModelesParMarque(com.hibernateMaven01.metier.Marque)
 	 *
	 * Retourne la liste des mod�les de la marque choisie
	 */
	@SuppressWarnings("unchecked")
	public List<Modele> findListeModelesByMarque(Marque marque) {
		List<Modele> liste = new ArrayList<Modele>();
//		Criteria criteria = HibernateUtil.getCurrentSession().createCriteria(
//				Modele.class);
//		criteria.add(Restrictions.isNotEmpty("marque"));
//		criteria.add(Restrictions.eq("marque", marque));
//		liste = criteria.list();
		return liste;
	}

	/**
	 * Sauvegarde ou met � jour un mod�le
	 *
	 * @param object : objet � sauvegarder ou � mettre � jour
	 */
	@Transactional
	public void save(Modele modele) {
//		Transaction transaction =
//			((GenericHibernateDao<Modele, Serializable>)this.modeleDao).getHibernateTemplate().getSessionFactory().getCurrentSession().getTransaction();
//		transaction.begin();
//		this.modeleDao.saveOrUpdate(modele);
//		// Cr�ation de l'�v�nement
//		ModeleSaveOrUpdateEvent modeleSaveOrUpdateEvent = new ModeleSaveOrUpdateEvent(this, modele);
//		// Publication de l'�v�nement
//		this.applicationEventPublisher.publishEvent(modeleSaveOrUpdateEvent);
//		transaction.commit();
		this.modeleDao.save(modele);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.context.ApplicationEventPublisherAware#setApplicationEventPublisher(org.springframework.context.ApplicationEventPublisher)
	 */
	/**
	 * L'interface ApplicationEventPublisherAware d�finit un accesseur pour avoir acc�s � l'�metteur d'�v�nements
	 */
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	/**
	 * @param modeleDao the modeleDao to set
	 */
	public void setModeleDao(GenericJpaDao<Modele> modeleDao) {
		this.modeleDao = modeleDao;
	}

}
