package com.rosana.store.service;

import com.rosana.store.dto.ProductTypeRequestDTO;
import com.rosana.store.dto.ProductTypeResponseDTO;
import com.rosana.store.entity.ProductType;
import com.rosana.store.mapper.ProductTypeMapper;
import com.rosana.store.repository.ProductTypeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public ProductTypeResponseDTO save(ProductTypeRequestDTO productTypeRequestDTO) {
        ProductType productType = ProductTypeMapper.INSTANCE.productTypeRequestDTOToProductType(productTypeRequestDTO);
        ProductType savedProductType = productTypeRepository.save(productType);
        return ProductTypeMapper.INSTANCE.productTypeToProductTypeResponseDTO(savedProductType);
    }

    public List<ProductTypeResponseDTO> findAll() {
        return productTypeRepository.findAll().stream().map(ProductTypeMapper.INSTANCE::productTypeToProductTypeResponseDTO).collect(
                Collectors.toList());
    }

    public ProductTypeResponseDTO findById(Long id) {
        ProductType productType = productTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo Produto não encontrado"));
        return ProductTypeMapper.INSTANCE.productTypeToProductTypeResponseDTO(productType);
    }

    public ProductTypeResponseDTO update(Long id, ProductTypeRequestDTO productTypeRequestDTO) {
        ProductType existingProductType = productTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Tipo Produto não encontrado"));

        existingProductType.setDescription(productTypeRequestDTO.getDescription());
        existingProductType.setActive(productTypeRequestDTO.getActive());

        ProductType updatedProductType = productTypeRepository.save(existingProductType);
        return ProductTypeMapper.INSTANCE.productTypeToProductTypeResponseDTO(updatedProductType);
    }

    public void delete(Long id) {
        productTypeRepository.deleteById(id);
    }

}

