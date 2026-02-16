package com.app.nutri.dao;

import com.app.nutri.dto.IngredientDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class IngredientDAO {

    private final JdbcTemplate jdbcTemplate;

    public IngredientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<IngredientDTO> findAll() {
        String sql = "SELECT id, name FROM nutri.v_ingredients";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new IngredientDTO(
                        rs.getLong("id"),
                        rs.getString("name")
                )
        );
    }
}

