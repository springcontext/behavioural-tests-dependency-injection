package com.springcontext.restapitests.api.helpers;

import com.springcontext.restapitests.api.dto.IngredientDto;
import com.springcontext.restapitests.domain.entities.Ingredient;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IngredientHelper {

    public static Ingredient dtoToEntity(IngredientDto dto) {
        return Ingredient.builder()
                .name(dto.getName())
                .build();
    }

    public static IngredientDto entityToDto(Ingredient entity) {
        return IngredientDto.builder()
                .name(entity.getName())
                .build();
    }
}
