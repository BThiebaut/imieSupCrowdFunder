package fr.imie.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.imie.supcrowdfunder.dao.CategoryDao;
import fr.imie.supcrowdfunder.entity.Category;

public class JpaCategoryDao implements CategoryDao {

	private EntityManagerFactory emf;
	private String sqlTable;
	
	public JpaCategoryDao(EntityManagerFactory emf) {
		this.emf = emf;
		this.sqlTable = "Categories";
	}
	
	@Override
	public List<Category> showAllCategories() {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT t FROM Category AS t");
		List<Category> category = query.getResultList();
		
		return category;
	}

	@Override
	public Category findCategory(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT t FROM Category AS t WHERE t.id = :ID");
		query.setParameter(":TABLE", this.sqlTable);
		query.setParameter(":ID", id);
		Category cat = (Category) query.getSingleResult();
		
		return cat;
	}

	// Prevent type error
	public Category findCategory(String id){
		return this.findCategory(Long.valueOf(id));
	}

	
	@Override
	public void addCategory(Category category) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			em.persist(category);
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
	public void removeCategory(Long id) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("DELETE FROM :TABLE as t WHERE t.id = :ID");
		query.setParameter(":TABLE", this.sqlTable);
		query.setParameter(":ID", id);
		query.executeUpdate();
		
	}
	
	// Prevent type error
	public void removeCategory(String id){
		this.removeCategory(Long.valueOf(id));
	}

	@Override
	public void updateCategory(Category category) {
		EntityManager em = emf.createEntityManager();
		Category p = em.find(Category.class, category.getId());
		
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			p.setName(category.getName());
			p.setDescription(category.getDescription());
			p.setProject(category.getProject());
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
