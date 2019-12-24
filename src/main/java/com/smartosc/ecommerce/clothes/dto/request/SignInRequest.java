package com.smartosc.ecommerce.clothes.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartosc.ecommerce.clothes.util.email.EmailConstraint;
import com.smartosc.ecommerce.clothes.util.name.NotContainSpecialCharacter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class SignInRequest implements Serializable {

    private static final long serialVersionUID = -8822837932183674804L;

    @NotNull
    @Column(name = "email")
    @JsonProperty("email")
    @NotEmpty(message = "{email.notempty}")
    @Size(min = 6, max = 64, message = "{email.size}")
    @EmailConstraint
    private String email;

    @NotNull
    @Column(name = "password")
    @JsonProperty("password")
    @NotEmpty(message = "{password.notempty}")
    @Size(min = 8, max = 32, message = "{password.size}")
    private String password;
}
