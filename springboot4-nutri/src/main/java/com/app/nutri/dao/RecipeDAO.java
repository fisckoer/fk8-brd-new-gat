package com.app.nutri.dao;


import com.app.nutri.dto.IngredientDTO;
import com.app.nutri.dto.RecipeDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
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
        


    
}
