package com.smartosc.ecommerce.clothes.service;


import com.smartosc.ecommerce.clothes.model.ShippingAddress;
import com.smartosc.ecommerce.clothes.model.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
