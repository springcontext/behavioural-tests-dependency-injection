package com.springcontext.restapitests.services;

import com.springcontext.restapitests.domain.entities.Ingredient;
import com.springcontext.restapitests.domain.entities.Recipe;
import com.springcontext.restapitests.domain.repositories.RecipeRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create_will_return_new_entity() throws Exception {

        String id = "11111111-2222-3333-44444444";
        String name = "mocked_recipe_name";
        String recipe = "mocked_recipe";
        Set<Ingredient> ingredients = new HashSet<>();

        Recipe entity = Recipe.builder()
                .id(id)
                .name(name)
                .recipe(recipe)
                .ingredients(ingredients)
                .build();

        Mockito.when(this.recipeRepository.findFirstByName(Mockito.any())).thenReturn(null);
        Mockito.when(this.recipeRepository.save(Mockito.any())).thenReturn(entity);

        Recipe someRecipe = this.recipeService.create(Recipe.builder().build());

        assertThat(someRecipe.getId()).isEqualTo(id);
        assertThat(someRecipe.getName()).isEqualTo(name);
        assertThat(someRecipe.getRecipe()).isEqualTo(recipe);
        assertThat(someRecipe.getIngredients()).containsExactlyElementsOf(ingredients);
    }

    @Test
    public void create_will_throw_existing_exception() throws Exception {

        expectedException.expect(Exception.class);
        expectedException.expectMessage("This recipe already exists");

        Mockito.when(this.recipeRepository.findFirstByName(Mockito.any())).thenReturn(
                Recipe.builder().name("").build());

        this.recipeService.create(Recipe.builder().build());
    }

    @Test
    public void get_by_name_will_return_entity() throws Exception {

        String id = "11111111-2222-3333-44444444";
        String name = "mocked_recipe_name";
        String recipe = "mocked_recipe";
        Set<Ingredient> ingredients = new HashSet<>();

        Recipe entity = Recipe.builder()
                .id(id)
                .name(name)
                .recipe(recipe)
                .ingredients(ingredients)
                .build();

        Mockito.when(this.recipeRepository.findFirstByName(name)).thenReturn(entity);

        Recipe someRecipe = this.recipeService.getByName(name);

        assertThat(someRecipe.getId()).isEqualTo(id);
        assertThat(someRecipe.getName()).isEqualTo(name);
        assertThat(someRecipe.getRecipe()).isEqualTo(recipe);
        assertThat(someRecipe.getIngredients()).containsExactlyElementsOf(ingredients);
    }

    @Test
    public void get_by_name_will_throw_not_found_exception() throws Exception {

        expectedException.expect(Exception.class);
        expectedException.expectMessage("This recipe does not exist");

        Mockito.when(this.recipeRepository.findFirstByName(Mockito.any())).thenReturn(null);

        this.recipeService.getByName("mocked_name");
    }
}
