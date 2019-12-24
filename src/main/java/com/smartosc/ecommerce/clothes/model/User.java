package com.smartosc.ecommerce.clothes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartosc.ecommerce.clothes.util.BaseEntity;
import com.smartosc.ecommerce.clothes.util.Status;
import com.smartosc.ecommerce.clothes.util.email.EmailConstraint;
import com.smartosc.ecommerce.clothes.util.name.NotContainSpecialCharacter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class User implements UserDetails {

    private static final long serialVersionUID = -7826694873142277715L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("user_id")
    private Long userId;

    @NotContainSpecialCharacter
    @Column(name = "full_name")
    @JsonProperty("full_name")
    private String fullName;

    @NotContainSpecialCharacter
    @Column(name = "user_name")
    @JsonProperty("user_name")
    @Size(min = 4, max = 50, message = "{username.size}")
    private String username;

    @NotNull
    @Column(name = "password")
    @JsonProperty("password")
    @NotEmpty(message = "{password.notempty}")
    private String password;

    @Basic
    @EmailConstraint
    @JsonProperty("email")
    @NotEmpty(message = "{email.notempty}")
    @Size(min = 6, max = 100, message = "{email.size}")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserShipping> userShippingList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPayment> userPaymentList;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    private int status;

    public User() {
        this.status = Status.VALID.getValue ();
    }

    public User(String fullName, String username, String password, String email) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorites = new HashSet<> ();
        userRoles.forEach(ur -> authorites.add(new Authority(ur.getRole().getName())));
        return authorites;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
