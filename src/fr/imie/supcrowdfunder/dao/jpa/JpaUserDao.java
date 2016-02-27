package fr.imie.supcrowdfunder.dao.jpa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.supcrowdfunder.dao.UserDao;
import fr.imie.supcrowdfunder.entity.User;

public class JpaUserDao implements UserDao {

	private EntityManagerFactory emf;
	private String sqlTable;
	
	public JpaUserDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<User> showAllUsers() {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT User FROM User");
		List<User> user = query.getResultList();
		user = this.replaceAt(user);
		return user;
	}

	@Override
	public User findUser(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT t FROM User AS t WHERE t.id = :ID");
		query.setParameter(":ID", id);
		User user = (User) query.getSingleResult();
		user = this.replaceAt(user);
		return user;
	}
	
	// Prevent type error
	public User findUser(String id){
		return this.findUser(Long.valueOf(id));
	}

	@Override
	public void addUser(User user) {
		EntityManager em = emf.createEntityManager();
		user.seteMail(user.geteMail().replace("@", "[at]"));
		
		user.setPassword(this.hashPassword(user.getPassword()));
		
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(user);
			t.commit();
			
		} finally {
			if(t.isActive()) {
				t.rollback();
			} else {
				em.close();
			}
		}
		
	}

	@Override
	public void removeUser(Long id) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("DELETE FROM Users as t WHERE t.id = :ID");
		query.setParameter(":ID", id);
		query.executeUpdate();
		
	}
	
	// Prevent type error
	public void removeUser(String id){
		this.removeUser(Long.valueOf(id));
	}

	@Override
	public void updateUser(User user) {
		EntityManager em = emf.createEntityManager();
		User item = em.find(User.class, user.getId());
		user = this.replaceArobas(user);
		String password = this.isChangedPassword(user) ? this.hashPassword(user.getPassword()) : user.getPassword();
		
		
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			item.setFirstName(user.getFirstName());
			item.setLastName(user.getLastName());
			item.seteMail(user.geteMail());
			item.setPassword(password);
			t.commit();
			
		} finally {
			if(t.isActive()) {
				t.rollback();
			} else {
				em.close();
			}
		}
		
	}
	
	private boolean isChangedPassword(User user){
		// Prevent hashing password already hashed
		
		User baseUser = this.findUser(user.getId());
		
		boolean result = baseUser.getPassword() != user.getPassword() ? true : false;
		
		return result;
		
	}
	
	public String hashPassword(String password){
		// Source : http://www.sha1-online.com/sha1-java/
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] result = mDigest.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
		    sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		// I supposed it should help
		System.gc();
		
		return sb.toString();
	}

	@Override
	public User authUser(String mail, String password) {
		String hashedPw = this.hashPassword(password);
		mail = this.replaceAt(mail);
		System.out.println(mail);
		System.out.println(hashedPw);
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT t FROM User AS t WHERE t.eMail = ?1 AND t.password = ?2");
		query.setParameter(1, mail);
		query.setParameter(2, hashedPw);
		User user = null;
		try {
			user = (User) query.getSingleResult();
		}catch (Exception e){
			System.out.println("User not found");
		}
		return user;
	}

	@Override
	public Boolean existUser(String mail) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT User FROM User AS u WHERE u.eMail = :mail");
		query.setParameter(":mail", mail);
		try {
			User user = (User) query.getSingleResult();
			System.out.println(user);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	// Prevent '@' char error and sql issue
	public User replaceAt(User user){
		user.seteMail(user.geteMail().replace("[at]", "@"));
		return user;
	}
	
	public List<User> replaceAt(List<User> user){
		for(User u : user){
			u.seteMail(u.geteMail().replace("[at]", "@"));
		}
		return user;
	}
	
	public User replaceArobas(User user){
		user.seteMail(user.geteMail().replace("@", "[at]"));
		return user;
	}
	
	public String replaceAt(String s){
		s = s.replace("@", "[at]");
		return s;
	}
	
}
