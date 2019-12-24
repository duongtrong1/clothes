package com.smartosc.ecommerce.clothes.repository;


import com.smartosc.ecommerce.clothes.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
