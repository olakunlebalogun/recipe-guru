package com.olakunle.controller;

import com.olakunle.services.RecipeService;
import com.olakunle.domain.Category;
import com.olakunle.domain.UnitOfMeasure;
import com.olakunle.repositories.CategoryRepository;
import com.olakunle.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
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
                log.debug("Getting Index page");
        model.addAttribute("recipes", recipeService.getRecipes());
        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        return "index";

    }


}
