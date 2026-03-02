package com.app.nutri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;


}
