package com.app.nutri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecipeDTO {
//r_name character varying, r_notes text, r_preparation text, r_calories integer, r_favorite boolean, r_image_url
    private int id;
    private String name;
    private String notes;
    private String preparation;
    private int calories;
    private boolean favorite;
    private String imageUrl;

}
