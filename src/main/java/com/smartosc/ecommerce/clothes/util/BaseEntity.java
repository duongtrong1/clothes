package com.smartosc.ecommerce.clothes.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -5365104633515076642L;

    @CreatedDate
    @Column(name = "created_at", unique = true, nullable = false)
    @JsonProperty("created_at")
    private long createdAt;

    @LastModifiedDate
    @JsonProperty("updated_at")
    @Column(name = "updated_at", unique = true, nullable = false)
    private long updatedAt;

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = System.currentTimeMillis();
    }

    @PrePersist
    protected void onSave() {
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }
}
