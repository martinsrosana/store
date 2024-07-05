package com.rosana.store.service;

import com.rosana.store.entity.Product;
import com.rosana.store.repository.ProductRepository;
import com.rosana.store.repository.ProductSpecifications;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Product update(Long id, Product product) {
           Product existingProduct = findById(id);
           existingProduct.setName(product.getName());
           existingProduct.setDescription(product.getDescription());
           existingProduct.setPrice(product.getPrice());
           existingProduct.setProductType(product.getProductType());
           return productRepository.save(existingProduct);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByFilters(String name, String description, Double minPrice, Double maxPrice, Long productTypeId) {
        return productRepository.findAll(
                ProductSpecifications.withFilters(name, description, minPrice, maxPrice, productTypeId));
    }
}



