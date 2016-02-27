package fr.imie.supcrowdfunder.dao;

import fr.imie.supcrowdfunder.dao.jpa.JpaCategoryDao;
import fr.imie.supcrowdfunder.dao.jpa.JpaUserDao;
import fr.imie.supcrowdfunder.util.PersistenceManager;
import fr.imie.supcrowdfunder.dao.jpa.JpaProjectDao;

public class DaoFactory {
	public static ProjectDao getJpaProjectDao() {
		return new JpaProjectDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static CategoryDao getJpaCategoryDao() {
		return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static UserDao getJpaUserDao() {
		return new JpaUserDao(PersistenceManager.getEntityManagerFactory());
	}
}
