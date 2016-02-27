package fr.imie.supcrowdfunder.dao;

import java.util.List;

import fr.imie.supcrowdfunder.entity.Project;
import fr.imie.supcrowdfunder.entity.User;

	public interface UserDao {
		
	public List<User> showAllUsers();
	
	public User findUser(Long id);
	
	public void addUser(User user);
	
	public void removeUser(Long id);
	
	public void updateUser(User user);
	
	public String hashPassword(String password);
	
	public User authUser(String mail, String password);
	
	public Boolean existUser(String mail);
}
