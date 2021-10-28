package com.mangeassets.jpa.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Entity
public class Asset {
	@Id
	@GeneratedValue
	private int id;
	@Column(unique=true)
	private String name;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "cat_id"), name = "cat_id")
	private Category category;
	
	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Asset(int id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Asset [id=" + id + ", name=" + name + "]";
	}
	
}
