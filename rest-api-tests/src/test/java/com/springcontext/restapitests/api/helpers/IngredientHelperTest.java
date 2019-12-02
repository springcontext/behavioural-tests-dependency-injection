package com.springcontext.restapitests.api.helpers;

import com.springcontext.restapitests.api.dto.IngredientDto;
import com.springcontext.restapitests.domain.entities.Ingredient;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientHelperTest {

    private final String ID = "mocked_id";
    private final String NAME = "mocked_name";

    @Test
    public void dto_to_entity_will_return_valid_entity() {

        IngredientDto dto = IngredientDto.builder()
                .name(NAME)
                .build();

        Ingredient entity = IngredientHelper.dtoToEntity(dto);

        assertThat(entity.getId()).isNull();
        assertThat(entity.getName()).isEqualTo(NAME);
    }

    @Test
    public void entity_to_entity_will_return_valid_dto() {

        Ingredient entity = Ingredient.builder()
                .id(ID)
                .name(NAME)
                .build();

        IngredientDto dto = IngredientHelper.entityToDto(entity);

        assertThat(dto.getName()).isEqualTo(NAME);
    }
}
