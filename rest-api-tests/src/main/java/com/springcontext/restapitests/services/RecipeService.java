package com.springcontext.restapitests.services;

import com.springcontext.restapitests.domain.entities.Recipe;
import com.springcontext.restapitests.domain.repositories.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe create(Recipe recipe) throws Exception {
        Recipe existingRecipe = this.recipeRepository.findFirstByName(recipe.getName());

        if (existingRecipe != null) {
            throw new Exception("This recipe already exists");
        }

        return this.recipeRepository.save(recipe);
    }

    public Recipe getByName(String name) throws Exception {
        Recipe existingRecipe = this.recipeRepository.findFirstByName(name);

        if (existingRecipe == null) {
            throw new Exception("This recipe does not exist");
        }

        return existingRecipe;
    }
}
