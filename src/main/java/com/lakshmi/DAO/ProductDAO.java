package com.lakshmi.DAO;

import java.util.List;

import com.lakshmi.domain.Category;
import com.lakshmi.domain.Product;

public interface ProductDAO {
	
	void saveProduct(Product product);
	List<Product> productList();
	
	void updateProduct(Product product);
	
	void deleteProduct(Integer productID);
	
	Product getProduct(Integer productID);

}
