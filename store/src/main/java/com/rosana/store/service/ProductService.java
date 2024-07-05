package com.rosana.store.service;

import com.rosana.store.dto.ProductRequestDTO;
import com.rosana.store.dto.ProductResponseDTO;
import com.rosana.store.entity.Product;
import com.rosana.store.entity.ProductType;
import com.rosana.store.mapper.ProductMapper;
import com.rosana.store.repository.ProductRepository;
import com.rosana.store.repository.ProductSpecifications;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        Product product = ProductMapper.INSTANCE.productRequestDTOToProduct(productRequestDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.INSTANCE.productToProductResponseDTO(savedProduct);
    }

    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll().stream().map(ProductMapper.INSTANCE::productToProductResponseDTO).collect(
                Collectors.toList());
    }

    public ProductResponseDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return ProductMapper.INSTANCE.productToProductResponseDTO(product);
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDTO) {
           Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

           existingProduct.setName(productRequestDTO.getName());
           existingProduct.setDescription(productRequestDTO.getDescription());
           existingProduct.setPrice(productRequestDTO.getPrice());

           // Mappea ProductType apenas se o Id for diferente de null
           if (productRequestDTO.getProductTypeId() != null) {
               ProductType productType = new ProductType();
               productType.setId(productRequestDTO.getProductTypeId());
               existingProduct.setProductType(productType);
           }

           Product updatedProduct = productRepository.save(existingProduct);
           return ProductMapper.INSTANCE.productToProductResponseDTO(updatedProduct);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductResponseDTO> findByFilters(String name, String description, Double minPrice, Double maxPrice, Long productTypeId) {
        return productRepository.findAll(ProductSpecifications.withFilters(name, description, minPrice, maxPrice, productTypeId))
                .stream().map(ProductMapper.INSTANCE::productToProductResponseDTO).collect(Collectors.toList());
    }
}



