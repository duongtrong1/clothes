package com.smartosc.ecommerce.clothes.repository;


import com.smartosc.ecommerce.clothes.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
