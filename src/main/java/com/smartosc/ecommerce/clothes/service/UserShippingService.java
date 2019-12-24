package com.smartosc.ecommerce.clothes.service;

import com.smartosc.ecommerce.clothes.model.UserShipping;

public interface UserShippingService {

	UserShipping findById(Long id);
	
	void removeById(Long id);
}
