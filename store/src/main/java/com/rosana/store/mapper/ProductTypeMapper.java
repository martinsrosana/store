package com.rosana.store.mapper;

import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.rosana.store.dto.ProductTypeRequestDTO;
import com.rosana.store.dto.ProductTypeResponseDTO;
import com.rosana.store.entity.ProductType;

@Mapper
public interface ProductTypeMapper {

        ProductTypeMapper INSTANCE = Mappers.getMapper(ProductTypeMapper.class);

        ProductTypeResponseDTO productTypeToProductTypeResponseDTO(ProductType productType);

        ProductType productTypeRequestDTOToProductType(ProductTypeRequestDTO productTypeRequestDTO);

}


