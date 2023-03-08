package com.olakunle.services;

import com.olakunle.commands.RecipeCommand;
import com.olakunle.domain.Recipe;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    void deleteById(Long idToDelete);

}
