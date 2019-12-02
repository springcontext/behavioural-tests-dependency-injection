package com.springcontext.restapitests.domain.entities;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientTest {

    @Test
    public void create_id_will_return_valid_uuid() {
        String uuidPattern = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}";
        Ingredient ingredient = Ingredient.builder()
                .id(null)
                .name("name")
                .build();

        assertThat(ingredient.getId()).isNull();

        ingredient.createId();

        assertThat(ingredient.getId()).matches(uuidPattern);
    }
}
