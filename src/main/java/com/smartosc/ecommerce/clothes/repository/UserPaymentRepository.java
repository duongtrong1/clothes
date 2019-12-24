package com.smartosc.ecommerce.clothes.repository;

import com.smartosc.ecommerce.clothes.model.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {

}
