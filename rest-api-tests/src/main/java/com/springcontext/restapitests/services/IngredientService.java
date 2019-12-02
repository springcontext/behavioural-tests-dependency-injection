package com.springcontext.restapitests.services;

import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    /*@Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient create(Ingredient ingredient) throws Exception {
        Ingredient existingIngredient = this.ingredientRepository.findFirstByName(ingredient.getName());

        if (existingIngredient != null) {
            throw new Exception("This ingredient already exists");
        }

        return this.ingredientRepository.save(ingredient);
    }

    public Ingredient getByName(String name) throws Exception {
        Ingredient existingIngredient = this.ingredientRepository.findFirstByName(name);

        if (existingIngredient == null) {
            throw new Exception("This ingredient does not exist");
        }

        return existingIngredient;
    }*/
}
