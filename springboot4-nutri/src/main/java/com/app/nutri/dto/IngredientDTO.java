package com.app.nutri.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor
@Data
public class IngredientDTO {
    private Long id;
    private String name;
}
