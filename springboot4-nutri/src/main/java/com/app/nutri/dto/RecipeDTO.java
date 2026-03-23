package com.app.nutri.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor
@Data
@ToString

public class RecipeDTO {
    private Long id;
    private String name;
    private String notes;
    private String preparation;
    private int calories;
    private Boolean favorite;
    private String type;
    private List<IngredientDTO>ingredients;
    public RecipeDTO(Long id, String name, String notes, String preparation, int calories, Boolean favorite,
            String type) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.preparation = preparation;
        this.calories = calories;
        this.favorite = favorite;
        this.type = type;
    }
    
   
}


