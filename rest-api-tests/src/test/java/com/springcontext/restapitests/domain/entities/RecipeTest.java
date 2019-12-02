package com.springcontext.restapitests.domain.entities;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecipeTest {

    @Test
    public void create_id_will_return_valid_uuid() {
        String uuidPattern = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}";

        Recipe recipe = Recipe.builder()
                .id(null)
                .name("name")
                .build();

        assertThat(recipe.getId()).isNull();

        recipe.createId();

        assertThat(recipe.getId()).matches(uuidPattern);
    }
}
