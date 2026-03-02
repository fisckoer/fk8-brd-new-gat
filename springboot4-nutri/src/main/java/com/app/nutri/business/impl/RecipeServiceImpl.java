package com.app.nutri.business.impl;

import org.springframework.stereotype.Service;

import com.app.nutri.business.RecipeService;
import com.app.nutri.business.dto.RecipesIntDTO;
import com.app.nutri.dao.RecipeDAO;
import com.app.nutri.dto.PaginationDTO;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeDAO dao;

    public RecipeServiceImpl(RecipeDAO dao) {
        this.dao = dao;
    }

    @Override
    public RecipesIntDTO getListRecipes(int page, int size) {
        int totalRecipes = dao.getTotalRecipes();
        int totalPages = (int) Math.ceil((double) totalRecipes / size);
        PaginationDTO pagination = new PaginationDTO(page, size, totalRecipes, totalPages); 
        return new RecipesIntDTO(pagination, dao.getListRecipes(page, size));
    }   

}
