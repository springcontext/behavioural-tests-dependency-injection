package com.springcontext.restapitests.api;

import com.springcontext.restapitests.api.dto.IngredientDto;
import com.springcontext.restapitests.api.dto.RecipeDto;
import com.springcontext.restapitests.domain.entities.Ingredient;
import com.springcontext.restapitests.domain.entities.Recipe;
import com.springcontext.restapitests.services.RecipeService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@EnableWebMvc
@SpringBootTest
public class RecipeControllerTest {

    private static final String ID = "mocked_id";
    private static final String NAME = "mocked_name";
    private static final String RECIPE = "mocked_recipe";
    private static final Set<Ingredient> INGREDIENTS = new HashSet<>();
    private static final Set<IngredientDto> INGREDIENTS_DTO = new HashSet<>();

    @Mock
    private RecipeService recipeService;

    private RecipeController recipeController;

    @Before
    public void setUp() {
        this.recipeController = new RecipeController(this.recipeService);
    }

    @Test
    public void get_recipe_will_return_valid_dto() throws Exception {

        Recipe recipe = Recipe.builder()
                .id(ID)
                .name(NAME)
                .recipe(RECIPE)
                .ingredients(INGREDIENTS)
                .build();

        Mockito.when(this.recipeService.getByName(NAME)).thenReturn(recipe);

        RecipeDto someRecipe = this.recipeController.getRecipe(NAME);

        assertThat(someRecipe.getName()).isEqualTo(NAME);
        assertThat(someRecipe.getRecipe()).isEqualTo(RECIPE);
        assertThat(someRecipe.getIngredients()).isEqualTo(INGREDIENTS_DTO);
    }

    @Test(expected = Exception.class)
    public void get_recipe_will_throw_not_found_exception() throws Exception {

        Mockito.when(this.recipeService.getByName(NAME)).thenThrow(new Exception("exception"));

        RecipeDto someRecipe = this.recipeController.getRecipe(NAME);
    }

    @Test
    public void create_will_return_valid_dto() throws Exception {

        RecipeDto dto = RecipeDto.builder()
                .name(NAME)
                .recipe(RECIPE)
                .ingredients(INGREDIENTS_DTO)
                .build();

        Recipe recipe = Recipe.builder()
                .id(ID)
                .name(NAME)
                .recipe(RECIPE)
                .ingredients(INGREDIENTS)
                .build();

        Mockito.when(this.recipeService.create(Mockito.any())).thenReturn(recipe);

        RecipeDto someRecipe = this.recipeController.create(dto);

        assertThat(someRecipe.getName()).isEqualTo(NAME);
        assertThat(someRecipe.getRecipe()).isEqualTo(RECIPE);
        assertThat(someRecipe.getIngredients()).isEqualTo(INGREDIENTS_DTO);
    }

    @Test(expected = Exception.class)
    public void create_will_throw_existing_exception() throws Exception {

        RecipeDto dto = RecipeDto.builder()
                .name(NAME)
                .recipe(RECIPE)
                .ingredients(INGREDIENTS_DTO)
                .build();

        Mockito.when(this.recipeService.create(Mockito.any())).thenThrow(new Exception("exception"));

        RecipeDto someRecipe = this.recipeController.create(dto);
    }
}
