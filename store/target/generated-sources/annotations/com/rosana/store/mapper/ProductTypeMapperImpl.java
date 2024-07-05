package com.rosana.store.mapper;

import com.rosana.store.dto.ProductTypeRequestDTO;
import com.rosana.store.dto.ProductTypeResponseDTO;
import com.rosana.store.entity.ProductType;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-05T20:13:12-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class ProductTypeMapperImpl implements ProductTypeMapper {

    @Override
    public ProductTypeResponseDTO productTypeToProductTypeResponseDTO(ProductType productType) {
        if ( productType == null ) {
            return null;
        }

        ProductTypeResponseDTO productTypeResponseDTO = new ProductTypeResponseDTO();

        productTypeResponseDTO.setId( productType.getId() );
        productTypeResponseDTO.setDescription( productType.getDescription() );
        productTypeResponseDTO.setActive( productType.isActive() );

        return productTypeResponseDTO;
    }

    @Override
    public ProductType productTypeRequestDTOToProductType(ProductTypeRequestDTO productTypeRequestDTO) {
        if ( productTypeRequestDTO == null ) {
            return null;
        }

        ProductType productType = new ProductType();

        productType.setDescription( productTypeRequestDTO.getDescription() );
        if ( productTypeRequestDTO.getActive() != null ) {
            productType.setActive( productTypeRequestDTO.getActive() );
        }

        return productType;
    }
}
