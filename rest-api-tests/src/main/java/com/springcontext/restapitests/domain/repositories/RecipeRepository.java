package com.springcontext.restapitests.domain.repositories;

import com.springcontext.restapitests.domain.entities.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

    Recipe findFirstByName(String name);
}
