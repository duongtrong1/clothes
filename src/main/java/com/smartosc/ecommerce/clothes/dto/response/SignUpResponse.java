package com.smartosc.ecommerce.clothes.dto.response;

import com.smartosc.ecommerce.clothes.model.User;

public class SignUpResponse extends User {

    private static final long serialVersionUID = -2223290315666617058L;

    @Override
    public String getPassword() {
        return "******";
    }
}
