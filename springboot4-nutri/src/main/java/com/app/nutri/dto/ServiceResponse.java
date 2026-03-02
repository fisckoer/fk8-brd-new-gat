package com.app.nutri.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceResponse <T>{

    private T data;
    private PaginationDTO pagination;
    //Control de errores mas adelante 
    //private Meta meta;
    //private List<ApiError> errors;
}
/*
public class Meta {

    private Long total;
    private Integer page;
    private Integer size;

    // constructores, getters y setters
}*/
/*public class ApiError {

    private String code;
    private String message;

    public ApiError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // getters y setters
}
 */