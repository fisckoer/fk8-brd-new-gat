package com.app.nutri.business;

import com.app.nutri.dto.IngredientDTO;
import com.app.nutri.facade.IngredientFacade;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class IngredientFacadeTest {

    private final IngredientService service = mock(IngredientService.class);
    private final IngredientFacade facade = new IngredientFacade(service);

    private final MockMvc mockMvc =
            MockMvcBuilders.standaloneSetup(facade).build();

    @Test
    void shouldReturnIngredientsJson() throws Exception {

        when(service.getIngredients()).thenReturn(
                List.of(new IngredientDTO(1L, "Tomate","cantidad", true,1))
        );

        mockMvc.perform(get("/api/ingredients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.[0].name").value("Tomate"));
    }
}