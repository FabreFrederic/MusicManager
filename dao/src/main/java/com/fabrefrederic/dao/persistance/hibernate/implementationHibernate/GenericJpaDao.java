package com.fabrefrederic.dao.persistance.hibernate.implementationHibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Frederic Fabre
 *
 * @param <T>
 */
@Repository
public class GenericJpaDao< T extends Serializable > {
	/** Classe à persister */
	protected Class< T > entityBeanType;

	/** */
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Constructor
	 */
	public GenericJpaDao(Class<T> persistentClass) {
		super();
		this.entityBeanType = persistentClass;
	}

	/**
	 * Constructor
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericJpaDao() {
		//		this.entityBeanType = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}


	/**
	 * 
	 * @param classToSet
	 */
	public void setClazz( final Class< T > classToSet ){
		this.entityBeanType = classToSet;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public T findOne( final Long id ){
		return this.entityManager.find( this.entityBeanType, id );
	}

	/**
	 * 
	 * @return
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List< T > findAll(){
		return this.entityManager.createQuery("from " + this.entityBeanType.getName()).getResultList();
	}

	/**
	 * 
	 * @param entity
	 */
	@Transactional
	public void save( final T entity ) {
		try {
			this.entityManager.persist( entity );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param entity
	 */
	public void update( final T entity ){
		this.entityManager.merge( entity );
	}

	/**
	 * 
	 * @param entity
	 */
	public void delete( final T entity ){
		this.entityManager.remove( entity );
	}

	/**
	 * 
	 * @param entityId
	 */
	public void deleteById( final Long entityId ){
		final T entity = this.findOne( entityId );
		this.delete( entity );
	}

	/**
	 * @return the entityBeanType
	 */
	public Class<T> getEntityBeanType() {
		return entityBeanType;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}