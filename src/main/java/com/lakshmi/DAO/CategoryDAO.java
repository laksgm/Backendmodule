package com.lakshmi.DAO;

import java.util.List;

import com.lakshmi.domain.Category;

public interface CategoryDAO {

	void addCategory(Category category);

	List<Category> categoryList();
	
	void updateCategory(Category category);
	
	void deleteCategory(Integer categoryId);
	
	Category getCategory(Integer categoryId);
}
