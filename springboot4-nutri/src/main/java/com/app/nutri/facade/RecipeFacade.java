package com.app.nutri.facade;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.nutri.business.RecipeService;
import com.app.nutri.dto.IngredientDTO;
import com.app.nutri.dto.RecipeDTO;
import com.app.nutri.dto.ServiceResponse;

@RestController
@RequestMapping("/api/recipes")
public class RecipeFacade {

    private final RecipeService service;

    public RecipeFacade(RecipeService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public ServiceResponse<List<RecipeDTO>> list() {
        List<RecipeDTO> data  = service.getRecipe();
        return ServiceResponse.<List<RecipeDTO>>builder()
        .data(data)
        .build();
    }

    @GetMapping("/{recipeId}/ingredients")
    public ServiceResponse<List<IngredientDTO>>getIngredientsByRecipe(@PathVariable Long recipeId){
        List<IngredientDTO> data = service.getIngredientsByRecipe(recipeId);
        return ServiceResponse.<List<IngredientDTO>>builder()
        .data(data)
        .build();

    }
    /* se agrega controlador para actualizar las recetas */
 @PutMapping("/{recipeId}")
 
    public ServiceResponse<String> updateRecipe(
        @PathVariable Long recipeId,
        @RequestBody RecipeDTO recipe) {

    // Asegurar que el ID del path se use
    recipe.setId(recipeId);

    boolean updated = service.updateRecipe(recipe);

    if (updated) {
        return ServiceResponse.<String>builder()
                .data("Receta actualizada correctamente")
                .build();
    } else {
        return ServiceResponse.<String>builder()
                .data("No se encontró la receta para actualizar")
                .build();
    }
    }
    /* esta parte es para crear la receta */
    @PostMapping
        public ServiceResponse<String> createRecipe(@RequestBody RecipeDTO recipe) {

        boolean created = service.createRecipe(recipe);

            String message = created
              ? "Receta creada correctamente"
              : "Error al crear receta";

         return ServiceResponse.<String>builder()
            .data(message)
            .build();
        }



}

