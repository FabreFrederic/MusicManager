/**
 *
 */
package com.hibernateMaven01.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fabrefrederic.metier.implementationTest.Client;
import com.fabrefrederic.metier.implementationTest.Guitare;
import com.fabrefrederic.metier.implementationTest.Marque;
import com.fabrefrederic.metier.implementationTest.Modele;
import com.fabrefrederic.service.interfaces.IModeleService;


/**
 *
 * Classe de test
 * @author frederic.fabre
 *
 */
public class test {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Contexts m�tiers
		ApplicationContext contextMetier =
				new ClassPathXmlApplicationContext("classpath:com/fabrefrederic/metier/springTest/applicationContext-Annotation.xml");
		// ApplicationContext contextMetier = new ClassPathXmlApplicationContext("classpath:com/fabrefrederic/metier/springTest/applicationContext-InjectionManuelle.xml");
		//ApplicationContext contextMetier = new ClassPathXmlApplicationContext("classpath:com/fabrefrederic/metier/springTest/applicationContext-detectionAutomatiquePackage.xml");

		// Contexts services
		ApplicationContext contextService =
				new ClassPathXmlApplicationContext("classpath:com/fabrefrederic/service/springTest/applicationContext-Service.xml");

		Marque marque = (Marque)contextMetier.getBean("marque");
		Guitare guitare = (Guitare)contextMetier.getBean("guitare");
		Modele modele = (Modele)contextMetier.getBean("modele");
		Client client = (Client)contextMetier.getBean("client");
		//		String[] tableau = contextService.getAliases("modeleService");
		//		List list = new ArrayList(Arrays.asList(tableau));
		//		IModeleService modeleService = (ModeleService)contextService.getBean("modeleService");
		//

		//Statistics statistics = HibernateUtil.getSessionfactory().getStatistics();

		marque.setNom("Gibson");
		modele.setMarque(marque);
		modele.setNom("Les paul");
		modele.setPrixCatalogue((double) 2000);
//		guitare.setModele(modele);

		Client client1 = modele.getClient();
		client1.setPrenom("prenomclient2");
		client1.setNom("nomclient2");
		modele.setClient(client1);

		IModeleService modeleService = (IModeleService)contextService.getBean("modeleService");

		try {
			modeleService.save(modele);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		//statistics.logSummary();
	}
}