package com.rosana.store.repository;

import com.rosana.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String nome);
    List<Product> findByPriceBetween(Double priceMin, Double priceMax);
    List<Product> findByDescription(String description);

}


