package com.app.nutri.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor
@Data
@ToString
public class IngredientDTO {
    private Long id;
    private String name;
    private String quantity;
    private boolean isOptional;
    private int optionGroup;
   
}
