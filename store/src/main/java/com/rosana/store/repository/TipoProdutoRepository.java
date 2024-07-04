package com.rosana.store.repository;

import com.rosana.store.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoProdutoRepository extends JpaRepository<ProductType, Long> {

}
