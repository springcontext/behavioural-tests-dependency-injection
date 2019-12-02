package com.springcontext.restapitests.api;

import com.springcontext.restapitests.api.dto.RecipeDto;
import com.springcontext.restapitests.api.helpers.RecipeHelper;
import com.springcontext.restapitests.domain.entities.Recipe;
import com.springcontext.restapitests.services.IngredientService;
import com.springcontext.restapitests.services.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/{recipeName}")
    public RecipeDto getRecipe(@PathVariable String recipeName) throws Exception {

        Recipe recipe = this.recipeService.getByName(recipeName);

        return RecipeHelper.entityToDto(recipe);
    }

    @PostMapping("/")
    public RecipeDto create(@RequestBody RecipeDto body) throws Exception {

        Recipe recipe = this.recipeService.create(RecipeHelper.dtoToEntity(body));

        return RecipeHelper.entityToDto(recipe);
    }
}
