package com.app.nutri.dao;

import com.app.nutri.dto.RecipeDTO;
import com.app.nutri.dto.IngredientDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeDAOTest {

    @Autowired
    private RecipeDAO recipeDAO;

    @Test
    void shouldReturnRecipes() {

        List<RecipeDTO> recipes = recipeDAO.findAll();

        assertNotNull(recipes);
        assertFalse(recipes.isEmpty());
        assertEquals("enchiladas ",recipes.get(0).getName());

    }


    @Test
 void shouldReturnIngredientsByRecipe() {

    List<IngredientDTO> ingredients = recipeDAO.getIngredientsByRecipe(1L);

    assertNotNull(ingredients);
    assertFalse(ingredients.isEmpty());
    assertEquals("tomate",ingredients.get(0).getName());
    }

}
