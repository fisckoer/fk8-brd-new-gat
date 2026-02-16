package com.app.nutri.business;

import com.app.nutri.dao.IngredientDAO;
import com.app.nutri.dto.IngredientDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientService {

    private final IngredientDAO dao;

    public IngredientService(IngredientDAO dao) {
        this.dao = dao;
    }

    public List<IngredientDTO> getIngredients() {
        return dao.findAll();
    }
}
