package com.springcontext.restapitests.api.helpers;

import com.springcontext.restapitests.api.dto.IngredientDto;
import com.springcontext.restapitests.api.dto.RecipeDto;
import com.springcontext.restapitests.domain.entities.Ingredient;
import com.springcontext.restapitests.domain.entities.Recipe;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class RecipeHelperTest {

    private final String ID = "mocked_id";
    private final String NAME = "mocked_name";
    private final String INGREDIENT_NAME = "mocked_ingredient_name";
    private final String RECIPE = "mocked_recipe";

    @Test
    public void dto_to_entity_will_return_valid_entity() {

        Set<IngredientDto> ingredients = new HashSet<>();

        IngredientDto ingredient = IngredientDto.builder()
                .name(INGREDIENT_NAME)
                .build();

        ingredients.add(ingredient);

        RecipeDto dto = RecipeDto.builder()
                .name(NAME)
                .recipe(RECIPE)
                .ingredients(ingredients)
                .build();

        Recipe entity = RecipeHelper.dtoToEntity(dto);

        assertThat(entity.getId()).isNull();
        assertThat(entity.getName()).isEqualTo(NAME);
        assertThat(entity.getRecipe()).isEqualTo(RECIPE);
        assertThat(entity.getIngredients()).hasSize(1);
    }

    @Test
    public void entity_to_entity_will_return_valid_dto() {

        Set<Ingredient> ingredients = new HashSet<>();

        Ingredient ingredient = Ingredient.builder()
                .name(INGREDIENT_NAME)
                .build();

        ingredients.add(ingredient);

        Recipe entity = Recipe.builder()
                .id(ID)
                .name(NAME)
                .recipe(RECIPE)
                .ingredients(ingredients)
                .build();

        RecipeDto dto = RecipeHelper.entityToDto(entity);

        assertThat(dto.getName()).isEqualTo(NAME);
        assertThat(dto.getRecipe()).isEqualTo(RECIPE);
        assertThat(dto.getIngredients()).hasSize(1);
    }
}
