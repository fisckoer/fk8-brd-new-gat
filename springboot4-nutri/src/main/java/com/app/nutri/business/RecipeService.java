package com.app.nutri.business;


import com.app.nutri.business.dto.RecipesIntDTO;



public interface RecipeService {
    RecipesIntDTO getListRecipes(int page, int size);

}
