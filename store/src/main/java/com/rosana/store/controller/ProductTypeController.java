package com.rosana.store.controller;

import com.rosana.store.entity.ProductType;
import com.rosana.store.service.ProductTypeService;
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
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/tipos")
@Validated
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping
    public ResponseEntity<ProductType> create(@Valid @RequestBody ProductType productType) {
        ProductType createdProductType = productTypeService.save(productType);
        return ResponseEntity.ok(createdProductType);
    }

    @GetMapping
    public ResponseEntity<List<ProductType>> getAll() {
        List<ProductType> tipos = productTypeService.findAll();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductType> getById(@PathVariable Long id) {
        ProductType productType = productTypeService.findById(id);
        return ResponseEntity.ok(productType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductType> update(@PathVariable Long id, @Valid @RequestBody ProductType productType) {
        ProductType updatedProductType = productTypeService.update(id, productType);
        return ResponseEntity.ok(updatedProductType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

