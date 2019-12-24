package com.smartosc.ecommerce.clothes.service;


import com.smartosc.ecommerce.clothes.model.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);
	
	void removeById(Long id);
}
