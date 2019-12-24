package com.smartosc.ecommerce.clothes.service;

import com.smartosc.ecommerce.clothes.model.UserShipping;
import com.smartosc.ecommerce.clothes.repository.UserShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	
	public UserShipping findById(Long id) {
		return userShippingRepository.findById (id).orElseThrow (null);
	}
	
	public void removeById(Long id) {
		userShippingRepository.deleteById (id);
	}

}
