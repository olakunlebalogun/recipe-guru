package com.olakunle.controller;

import com.olakunle.bootstrap.services.RecipeService;
import com.olakunle.domain.Category;
import com.olakunle.domain.UnitOfMeasure;
import com.olakunle.repositories.CategoryRepository;
import com.olakunle.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    // for lesson 140
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    public IndexController(RecipeService recipeService, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat has an Id: " + optionalCategory.get().getId());
        System.out.println("UOM has an Id: " + optionalUnitOfMeasure.get().getId());
        return "index";

    }

}
