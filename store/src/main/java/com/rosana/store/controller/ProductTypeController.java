package com.rosana.store.controller;

import com.rosana.store.dto.ProductTypeRequestDTO;
import com.rosana.store.dto.ProductTypeResponseDTO;
import com.rosana.store.entity.ProductType;
import com.rosana.store.service.ProductTypeService;
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
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/tipos")
@Transactional
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping
    public ResponseEntity<ProductTypeResponseDTO> create(@RequestBody ProductTypeRequestDTO productTypeRequestDTO) {
        ProductTypeResponseDTO createdProductType = productTypeService.save(productTypeRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductType);
    }

    @GetMapping
    public List<ProductTypeResponseDTO> getAll() {
        return productTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeResponseDTO> getById(@PathVariable Long id) {
        try{
            ProductTypeResponseDTO productType = productTypeService.findById(id);
            return ResponseEntity.ok(productType);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTypeResponseDTO> update(@PathVariable Long id, @RequestBody ProductTypeRequestDTO productTypeRequestDTO) {
        try {
            ProductTypeResponseDTO updatedProductType = productTypeService.update(id, productTypeRequestDTO);
            return ResponseEntity.ok(updatedProductType);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

