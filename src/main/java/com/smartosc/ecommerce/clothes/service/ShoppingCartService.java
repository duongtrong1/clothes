package com.smartosc.ecommerce.clothes.service;


import com.smartosc.ecommerce.clothes.model.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
	
	void clearShoppingCart(ShoppingCart shoppingCart);
}
