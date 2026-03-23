package com.app.nutri.business;

import com.app.nutri.dto.IngredientDTO;
import com.app.nutri.facade.RecipeFacade;
import com.app.nutri.business.RecipeService;
import com.app.nutri.dto.RecipeDTO;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RecipeFacadeTest {


    private final RecipeService service = mock(RecipeService.class);
    private final RecipeFacade  facade = new RecipeFacade(service);
    
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(facade).build();

    @Test
    void shouldReturnRecipeJson() throws Exception {

        when( service.getRecipe()). thenReturn (
            List.of(new RecipeDTO(1L,
                 "enchiladas verdes",
                 "notas",
                 "preparacion",
                 350,
                 false,
                 "comida"))
        );

        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk())
              .andExpect(jsonPath("$.data[0].name").value("enchiladas verdes"));
              verify(service).getRecipe();

    }
@Test
    void shouldReturnIngredientsByRecipeJson () throws Exception{

        when(service.getIngredientsByRecipe(1L)).thenReturn(
            List.of(new IngredientDTO(1L, "lechuga"))
        );

        mockMvc.perform(get("/api/recipes/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].name").value("lechuga"));
    }

    
}






