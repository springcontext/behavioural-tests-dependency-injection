package com.springcontext.restapitests.api.helpers;

import com.springcontext.restapitests.api.dto.IngredientDto;
import com.springcontext.restapitests.api.dto.RecipeDto;
import com.springcontext.restapitests.domain.entities.Ingredient;
import com.springcontext.restapitests.domain.entities.Recipe;

import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecipeHelper {

    public static Recipe dtoToEntity(RecipeDto dto) {

        Set<Ingredient> ingredients = new HashSet<>();

        dto.getIngredients().forEach(ingredient -> ingredients.add(IngredientHelper.dtoToEntity(ingredient)));
        return Recipe.builder()
                .name(dto.getName())
                .ingredients(ingredients)
                .recipe(dto.getRecipe())
                .build();
    }

    public static RecipeDto entityToDto(Recipe entity) {

        Set<IngredientDto> ingredients = new HashSet<>();
        entity.getIngredients().forEach(ingredient -> ingredients.add(IngredientHelper.entityToDto(ingredient)));

        return RecipeDto.builder()
                .name(entity.getName())
                .ingredients(ingredients)
                .recipe(entity.getRecipe())
                .build();
    }
}
