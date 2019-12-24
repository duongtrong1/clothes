package com.smartosc.ecommerce.clothes.service;

import com.smartosc.ecommerce.clothes.model.Payment;
import com.smartosc.ecommerce.clothes.model.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
