package com.smartosc.ecommerce.clothes.repository;

import com.smartosc.ecommerce.clothes.model.BookToCartItem;
import com.smartosc.ecommerce.clothes.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookToCartItemRepository extends JpaRepository<BookToCartItem, Long> {
	void deleteByCartItem(CartItem cartItem);
}
