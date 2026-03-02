package com.app.nutri.facade.v0.recipe;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.nutri.business.RecipeService;
import com.app.nutri.business.dto.RecipesIntDTO;
import com.app.nutri.dto.RecipeDTO;
import com.app.nutri.dto.ServiceResponse;


@RestController
@RequestMapping(path = "/api/v0", produces=MediaType.APPLICATION_JSON_VALUE)
public class RecipeServiceFacade {

    private final RecipeService service;

    public RecipeServiceFacade(RecipeService service) {
        this.service = service;
    }

    @GetMapping(path = "/recipes" ,produces=MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse<List<RecipeDTO>> getListRecipe(@RequestParam(defaultValue = "1",required=false) int page,
         @RequestParam( defaultValue = "10",required=false)
         int size) {

        RecipesIntDTO result = service.getListRecipes( page, size);
       

        return ServiceResponse.<List<RecipeDTO>>builder()
                .data(result.getRecipes())
                .pagination(result.getPagination())
                .build();
    }




}
