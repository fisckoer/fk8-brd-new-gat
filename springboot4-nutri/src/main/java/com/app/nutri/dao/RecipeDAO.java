/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.app.nutri.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.nutri.dto.RecipeDTO;

@Repository
public class RecipeDAO {

    private final JdbcTemplate jdbcTemplate;

    public RecipeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RecipeDTO> getListRecipes(int pag, int size) {
        String sql = "SELECT * from nutri.get_recipes_paginated(?,?)";
        //r_id bigint,r_name character varying, r_notes text, r_preparation text, r_calories integer, r_favorite boolean, r_image_url
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new RecipeDTO(
                        rs.getInt("r_id"),
                        rs.getString("r_name"),
                        rs.getString("r_notes"),
                        rs.getString("r_preparation"),
                        rs.getInt("r_calories"),
                        rs.getBoolean("r_favorite"),
                        rs.getString("r_image_url")
                )
        ,pag-1,size);  
    }

    public int getTotalRecipes() {
        String sql = "SELECT count(*) from nutri.recipe";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


}
