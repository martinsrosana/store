package com.rosana.store.mapper;

import com.rosana.store.dto.ProductRequestDTO;
import com.rosana.store.dto.ProductResponseDTO;
import com.rosana.store.entity.Product;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

        ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

        // Mapping for Product to ProductResponseDTO
        @Mapping(source = "productType", target = "productType")
        ProductResponseDTO productToProductResponseDTO(Product product);

        // Mapping for ProductRequestDTO to Product
        @Mapping(source = "productTypeId", target = "productType.id")
        Product productRequestDTOToProduct(ProductRequestDTO productRequestDTO);

}


