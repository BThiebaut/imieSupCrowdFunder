package fr.imie.supcrowdfunder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String description;
	
	private Long id_creator;
	
	// I replace the end date by the found objective Because i have an Exception like
	//at java.util.Date.parse(Unknown Source)
	//at java.util.Date.<init>(Unknown Source)
	// Before include date function ...
	
	private int objective;
	
	@ManyToOne
	@JoinTable(name="category_project")
	private Category category;
	
	@ManyToMany(mappedBy="projects")
	private List<User> user;
	
	private Double fownd;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId_creator() {
		return id_creator;
	}
	public void setId_creator(Long id_creator) {
		this.id_creator = id_creator;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Double getFownd() {
		return fownd;
	}
	public void setFownd(Double fownd) {
		this.fownd = fownd;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getObjective() {
		return this.objective;
	}
	public void setObjective(int objective) {
		this.objective = objective;
	}
	
}