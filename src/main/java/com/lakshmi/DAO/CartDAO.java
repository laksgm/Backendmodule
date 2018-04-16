package com.lakshmi.DAO;

import java.util.List;

import com.lakshmi.domain.Cart;
import com.lakshmi.domain.User;

public interface CartDAO {

	void saveCartItem(Cart cart);

	void delete(Integer cartId);

	void update(Cart cart);

	List<Cart> findByEmail(String email);
	
	Cart retrievCartItem(Integer cartId);

}
