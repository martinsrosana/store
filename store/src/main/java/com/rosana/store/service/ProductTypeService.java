package com.rosana.store.service;

import com.rosana.store.entity.ProductType;
import com.rosana.store.repository.TipoProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    public ProductType save(ProductType productType) {
        return tipoProdutoRepository.save(productType);
    }

    public List<ProductType> findAll() {
        return tipoProdutoRepository.findAll();
    }

    public ProductType findById(Long id) {
        return tipoProdutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo Produto não encontrado"));
    }

    public ProductType update(Long id, ProductType productType) {
        ProductType existingProductType = findById(id);
        existingProductType.setDescription(productType.getDescription());
        existingProductType.setActive(productType.isActive());
        return tipoProdutoRepository.save(existingProductType);
    }

    public void delete(Long id) {
        ProductType productType = findById(id);
        productType.setActive(false);
        tipoProdutoRepository.save(productType);
    }

}

