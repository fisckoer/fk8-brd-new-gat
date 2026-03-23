package com.app.nutri.business;

import com.app.nutri.dao.RecipeDAO;
import com.app.nutri.dto.IngredientDTO;
import com.app.nutri.dto.RecipeDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class RecipeService{

    private final RecipeDAO dao;
    public RecipeService( RecipeDAO dao) {
        this.dao = dao;
    }

    public List<RecipeDTO> getRecipe(){
      // paso1 obtengo la lista de recetas
        List<RecipeDTO> listRecipe = dao.findAll();
//paso 2 recorro la lista de recetas
         for(int i=0; i<listRecipe.size();i++){
            //paso 3 obtengo los ingredientes por el id de la receta
           List<IngredientDTO> rIngredients =  getIngredientsByRecipe(listRecipe.get(i).getId());
          // System.err.println(rIngredients);
            //paso 4 asignar ingredientes a receta
            listRecipe.get(i).setIngredients(rIngredients);
         }
        
       // return dao.findAll();
        return listRecipe;
    }
    
    public List<IngredientDTO>getIngredientsByRecipe(long recipeId){
        return dao.getIngredientsByRecipe(recipeId);
    }
/* esta parte del codigo es para actualizar el recetario */
    public boolean updateRecipe(RecipeDTO recipe) {

    // Validación básica
     if (recipe == null || recipe.getId() == null) {
        throw new IllegalArgumentException("La receta debe tener un ID válido");
      }

    // Opcional: validar si existe antes
    // if (!dao.existsById(recipe.getId())) {
    //     return false;
    // }

    int rows = dao.updateRecipe(recipe);

    return rows > 0;
    }
    
}