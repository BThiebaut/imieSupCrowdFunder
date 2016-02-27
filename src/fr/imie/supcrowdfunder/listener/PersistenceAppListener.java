package fr.imie.supcrowdfunder.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.imie.supcrowdfunder.util.PersistenceManager;


@WebListener(value="/closeEMF")
public class PersistenceAppListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		PersistenceManager.closeEntityManagerFactory();
	}

	

}
