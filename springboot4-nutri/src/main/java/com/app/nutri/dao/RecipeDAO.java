package com.app.nutri.dao;


import com.app.nutri.dto.IngredientDTO;
import com.app.nutri.dto.RecipeDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RecipeDAO {

     private final JdbcTemplate jdbcTemplate;

    public RecipeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
     public List<RecipeDTO> findAll() {
        String sql = "SELECT id, name, notes, preparation, calories, favorite, recipe_type FROM nutri.v_recipe";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new RecipeDTO(
                     rs.getLong("id"),
                     rs.getString("name"),
                     rs.getString("notes"),
                     rs.getString("preparation"),
                     rs.getInt("calories"),
                     rs.getBoolean("favorite"),
                     rs.getString("recipe_type")
                )
        );
    }

    public List<IngredientDTO> getIngredientsByRecipe(Long recipeId) {
    String sql = "SELECT * from nutri.get_recipe_ingredient(?)";

    return jdbcTemplate.query(sql,  (rs, rowNum) -> 
            new IngredientDTO(
            rs.getLong("i_id"),
            rs.getString("i_name"),
            rs.getString("quantity"),
            rs.getBoolean("is_optional"),
            rs.getInt("option_group")
            ), recipeId

     );
    
        }

   /* esta parte es para actualizar el recetario */
      public int updateRecipe(RecipeDTO recipe) {
    String sql = """
        UPDATE nutri.recipe
        SET name = ?, 
            notes = ?, 
            preparation = ?, 
            calories = ?, 
            favorite = ?
            
        WHERE id = ?
         """;

    return jdbcTemplate.update(sql,
            recipe.getName(),
            recipe.getNotes(),
            recipe.getPreparation(),
            recipe.getCalories(),
            recipe.getFavorite(),
            recipe.getId()
    );
    }
    /*  esta parte inserta la receta */
    public Long insertRecipe(RecipeDTO recipe) {
    String sql = """ 
    INSERT INTO nutri.recipe (name, notes, preparation, calories, favorite, type) 
    VALUES (?, ?, ?, ?, ?, ?)
    """;

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
        ps.setString(1, recipe.getName());
        ps.setString(2, recipe.getNotes());
        ps.setString(3, recipe.getPreparation());
        ps.setInt(4, recipe.getCalories());
        ps.setBoolean(5, recipe.getFavorite());
        ps.setString(6, recipe.getType());
        return ps;
    }, keyHolder);

    return keyHolder.getKey().longValue();

    }
/* esta parte es para insertar los ingredientes a la receta */
    public void insertIngredient(Long recipeId, IngredientDTO ing) {
    String sql = """
        INSERT INTO nutri.recipe_ingredient 
        (recipe_id, name, quantity, is_optional, option_group)
        VALUES (?, ?, ?, ?, ?)
    """;

    jdbcTemplate.update(sql,
        recipeId,
        ing.getName(),
        ing.getQuantity(),
        ing.isOptional(),
        ing.getOptionGroup()
    );
}
 

        


    
}
