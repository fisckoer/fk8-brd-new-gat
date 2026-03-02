package com.app.nutri.business.dto;


import java.util.List;

import com.app.nutri.dto.PaginationDTO;
import com.app.nutri.dto.RecipeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipesIntDTO {

    private PaginationDTO pagination;
    private List<RecipeDTO> recipes;


}
