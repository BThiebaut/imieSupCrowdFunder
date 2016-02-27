package fr.imie.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.supcrowdfunder.dao.ProjectDao;
import fr.imie.supcrowdfunder.entity.Project;

public class JpaProjectDao implements ProjectDao {
	
	private EntityManagerFactory emf;
	private String sqlTable;
	
	public JpaProjectDao(EntityManagerFactory emf) {
		this.emf = emf;
		// change this for change all table request from class
		this.sqlTable = "Projects";
	}

	@Override
	public List<Project> showAllProjects() {
		
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Project AS p");
		List<Project> projects = query.getResultList();
		
		return projects;
	}

	@Override
	public Project findProject(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT t FROM Project AS t WHERE t.id = :ID");
		query.setParameter(":ID", id);
		Project project = (Project) query.getSingleResult();
		
		return project;
	}
	
	// Prevent type error
	public Project findProject(String id){
		return this.findProject(Long.valueOf(id));
	}

	@Override
	public void addProject(Project project) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(project);
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
	public void removeProject(Long id) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("DELETE FROM Project as t WHERE t.id = :ID");
		query.setParameter(":TABLE", this.sqlTable);
		query.setParameter(":ID", id);
		query.executeUpdate();
	}
	
	// Prevent type error
	public void removeProject(String id){
		this.removeProject(Long.valueOf(id));
	}

	@Override
	public void updateProject(Project project) {
		EntityManager em = emf.createEntityManager();
		Project p = em.find(Project.class, project.getId());
		
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			p.setName(project.getName());
			p.setDescription(project.getDescription());
			p.setFownd(project.getFownd());
			p.setCategory(project.getCategory());
			p.setUser(project.getUser());
			t.commit();
			
		} finally {
			if(t.isActive()) {
				t.rollback();
			} else {
				em.close();
			}
		}
		
		
	}
	
}
