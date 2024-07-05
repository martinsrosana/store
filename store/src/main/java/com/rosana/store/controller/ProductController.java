package com.rosana.store.controller;

import com.rosana.store.entity.Product;
import com.rosana.store.service.ProductService;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@Validated
public class ProductController {

        @Autowired
        private ProductService productService;

        @PostMapping
        public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
            Product createdProduct = productService.save(product);
            return ResponseEntity.ok(createdProduct);
        }

        @GetMapping
        public ResponseEntity<List<Product>> getAll() {
            List<Product> products = productService.findAll();
            return ResponseEntity.ok(products);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Product> getById(@PathVariable Long id) {
            Product product = productService.findById(id);
            return ResponseEntity.ok(product);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
            Product updatedProduct = productService.update(id, product);
            return ResponseEntity.ok(updatedProduct);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            productService.delete(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("/filtros")
        public ResponseEntity<List<Product>> findByFilters(
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String description,
                @RequestParam(required = false) Double minPrice,
                @RequestParam(required = false) Double maxPrice,
                @RequestParam(required = false) Long productTypeId
                ){
            List<Product> filters = productService.findByFilters(name, description, minPrice, maxPrice, productTypeId);
            return ResponseEntity.ok(filters);
        }
}
