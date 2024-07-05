package com.rosana.store.dto;

import lombok.Data;

@Data
public class ProductTypeResponseDTO {

    private Long id;
    private String description;
    private Boolean active;

}
