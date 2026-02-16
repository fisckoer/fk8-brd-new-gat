package com.app.nutri.facade;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.nutri.business.IngredientService;
import com.app.nutri.dto.IngredientDTO;
import com.app.nutri.dto.ServiceResponse;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientFacade {

    private final IngredientService service;

    public IngredientFacade(IngredientService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public ServiceResponse<List<IngredientDTO>> list() {
        List<IngredientDTO> data  = service.getIngredients();
        data.get(0).getName();
        return ServiceResponse.<List<IngredientDTO>>builder()
        .data(data)
        .build();
    }
}
