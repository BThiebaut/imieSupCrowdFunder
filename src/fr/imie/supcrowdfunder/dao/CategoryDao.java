package fr.imie.supcrowdfunder.dao;

import java.util.List;

import fr.imie.supcrowdfunder.entity.Category;

public interface CategoryDao {

  public List<Category> showAllCategories();

  public Category findCategory(Long id);

  public void addCategory(Category category);

  public void removeCategory(Long id);

  public void updateCategory(Category category);

}