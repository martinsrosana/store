package com.rosana.store.mapper;

import com.rosana.store.dto.ProductRequestDTO;
import com.rosana.store.dto.ProductResponseDTO;
import com.rosana.store.dto.ProductTypeResponseDTO;
import com.rosana.store.entity.Product;
import com.rosana.store.entity.ProductType;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-05T20:13:12-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponseDTO productToProductResponseDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setProductType( productTypeToProductTypeResponseDTO( product.getProductType() ) );
        productResponseDTO.setId( product.getId() );
        productResponseDTO.setName( product.getName() );
        productResponseDTO.setDescription( product.getDescription() );
        productResponseDTO.setPrice( product.getPrice() );

        return productResponseDTO;
    }

    @Override
    public Product productRequestDTOToProduct(ProductRequestDTO productRequestDTO) {
        if ( productRequestDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductType( productRequestDTOToProductType( productRequestDTO ) );
        product.setName( productRequestDTO.getName() );
        product.setDescription( productRequestDTO.getDescription() );
        product.setPrice( productRequestDTO.getPrice() );

        return product;
    }

    protected ProductTypeResponseDTO productTypeToProductTypeResponseDTO(ProductType productType) {
        if ( productType == null ) {
            return null;
        }

        ProductTypeResponseDTO productTypeResponseDTO = new ProductTypeResponseDTO();

        productTypeResponseDTO.setId( productType.getId() );
        productTypeResponseDTO.setDescription( productType.getDescription() );
        productTypeResponseDTO.setActive( productType.isActive() );

        return productTypeResponseDTO;
    }

    protected ProductType productRequestDTOToProductType(ProductRequestDTO productRequestDTO) {
        if ( productRequestDTO == null ) {
            return null;
        }

        ProductType productType = new ProductType();

        productType.setId( productRequestDTO.getProductTypeId() );

        return productType;
    }
}
