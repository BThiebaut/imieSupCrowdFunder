package fr.imie.supcrowdfunder.dao;

import java.util.List;

import fr.imie.supcrowdfunder.entity.Project;

public interface ProjectDao {

  public List<Project> showAllProjects();

  public Project findProject(Long id);
  public Project findProject(String id);

  public void addProject(Project project);

  public void removeProject(Long id);

  public void updateProject(Project project);
}
