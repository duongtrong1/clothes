package com.smartosc.ecommerce.clothes.service;


import com.smartosc.ecommerce.clothes.model.BillingAddress;
import com.smartosc.ecommerce.clothes.model.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
