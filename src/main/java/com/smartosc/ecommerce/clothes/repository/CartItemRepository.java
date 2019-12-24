package com.smartosc.ecommerce.clothes.repository;

import com.smartosc.ecommerce.clothes.model.CartItem;
import com.smartosc.ecommerce.clothes.model.Order;
import com.smartosc.ecommerce.clothes.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	List<CartItem> findByOrder(Order order);
}
