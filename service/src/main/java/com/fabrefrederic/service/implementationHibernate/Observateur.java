package com.fabrefrederic.service.implementationHibernate;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 
 * @author frederic.fabre
 * 
 */
public class Observateur implements ApplicationListener {

    /**
     * A chaque �v�nement publi�, pour chaque observateur qui implemente ApplicationListener, Spring va executer la
     * m�thode onApplicationEvent Il faut que l'observateur ait �t� d�clar� dans le m�me application context que celui
     * du bean qui publie l'event
     */
    @Override
    public void onApplicationEvent(final ApplicationEvent event) {
        if (ModeleSaveOrUpdateEvent.class.isInstance(event)) {
            System.out
                    .println("Evenement enclench� : cr�ation d'un modele par le service ModeleService.modeleSaveOrUpdate()");
        }
    }

}
