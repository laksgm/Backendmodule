package com.lakshmi.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Cart {

	@Id
	@GeneratedValue
	private Integer cartId;
	private int quantity;
	private String priceInCart;
	private String imageInCart;
	private String productNameInCart;
	@OneToOne
	@JoinColumn
	private User user;

	

	public String getProductNameInCart() {
		return productNameInCart;
	}

	public void setProductNameInCart(String productNameInCart) {
		this.productNameInCart = productNameInCart;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPriceInCart() {
		return priceInCart;
	}

	public void setPriceInCart(String priceInCart) {
		this.priceInCart = priceInCart;
	}

	public String getImageInCart() {
		return imageInCart;
	}

	public void setImageInCart(String imageInCart) {
		this.imageInCart = imageInCart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
