package com.rosana.store.controller;

import com.rosana.store.dto.ProductRequestDTO;
import com.rosana.store.dto.ProductResponseDTO;
import com.rosana.store.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
@Transactional
public class ProductController {

        @Autowired
        private ProductService productService;

        @PostMapping
        public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
            ProductResponseDTO createdProduct = productService.save(productRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        }

        @GetMapping
        public List<ProductResponseDTO> getAll() {
            return productService.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id) {
            try{
                ProductResponseDTO product = productService.findById(id);
                return ResponseEntity.ok(product);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO productRequestDTO) {
            try{
                ProductResponseDTO updatedProduct = productService.update(id, productRequestDTO);
                return ResponseEntity.ok(updatedProduct);
            } catch ( Exception e) {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            productService.delete(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/filtros")
        public List<ProductResponseDTO> findByFilters(
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String description,
                @RequestParam(required = false) Double minPrice,
                @RequestParam(required = false) Double maxPrice,
                @RequestParam(required = false) Long productTypeId
                ){
            return productService.findByFilters(
                    name,
                    description,
                    minPrice,
                    maxPrice,
                    productTypeId
            );
        }
}
