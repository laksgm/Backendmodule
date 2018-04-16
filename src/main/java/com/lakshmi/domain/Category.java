package com.lakshmi.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Integer catId;
	
	@OneToMany(targetEntity=Product.class,  fetch=FetchType.EAGER, mappedBy="category")
	private Set<Product> products = new HashSet<Product>(0);
	
	private String categoryName;
	private String categoryDescription;
	private String categoryDate;
	private String categoryAddedBy;

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryDate() {
		return categoryDate;
	}

	public void setCategoryDate(String categoryDate) {
		this.categoryDate = categoryDate;
	}

	public String getCategoryAddedBy() {
		return categoryAddedBy;
	}

	public void setCategoryAddedBy(String categoryAddedBy) {
		this.categoryAddedBy = categoryAddedBy;
	}

}
