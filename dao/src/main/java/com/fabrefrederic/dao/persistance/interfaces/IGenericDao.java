/**
 *
 */
package com.fabrefrederic.dao.persistance.interfaces;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * Interface DAO g�n�rique
 * @author frederic.fabre
 *
 * @param <T> Entit�
 * @param <ID> identifiant entit�
 */
public interface IGenericDao<T, ID extends Serializable> {

	/**
	 * Supprime toutes les entit�s de la session
	 */
	public void clear();

	/**
	 * Suppression d'une entit� en base
	 * @param entity : entit� � supprimer
	 */
	public void delete(T entity);

	/**
	 * Supression d'une entit� en base
	 * @param entity entit� � supprimer
	 * @param id : id de l'entit� � supprimer
	 */
	public void delete(T entity, ID id);

	/**
	 * Renvoie une liste d'entit� du type "persistentClass" correspondant aux crit�res (Criterion) pass�s en parametre
	 * @param criterion : liste de criteres de recherche
	 */
	public List<T> find(Criterion... criterion);

	/**
	 * Cherche une entit� par l'ID
	 * @param id : id de l'entit� � retourner
	 * @return Retourne : l'entit� trouv�e
	 */
	public T find(ID id);

    /**
     * Search for the complet list
     * 
     * @return List entities
     */
	public List<T> findAll();
		
	/**
	 * Flush
	 */
	public void flush();

	/**
	 * Sauvegarde ou met � jour un objet
	 * @param entity : objet � sauvegarder ou � mettre � jour
	 */
	public void saveOrUpdate(T entity);
}