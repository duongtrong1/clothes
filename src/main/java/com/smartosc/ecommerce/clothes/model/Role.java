package com.smartosc.ecommerce.clothes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartosc.ecommerce.clothes.util.AuditListener;
import com.smartosc.ecommerce.clothes.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityListeners(value = AuditListener.class)
public class Role implements Serializable {

    private static final long serialVersionUID = -2859743254167900267L;

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(name = "role_name")
    @JsonProperty("role_name")
    @NotEmpty(message = "{role.name.notempty}")
    @Size(min = 3, max = 25, message = "{role.name.size}")
    private String name;

    @OneToMany(mappedBy = "role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<> ();
}
