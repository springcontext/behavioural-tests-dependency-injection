package com.springcontext.restapitests.domain.entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipes")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Recipe {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    private String recipe;

    @ManyToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients;

    @PrePersist
    public void createId() {
        this.id = UUID.randomUUID().toString();
    }
}
