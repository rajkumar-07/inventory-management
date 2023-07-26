package com.Application.Inventory.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Application.Inventory.Entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByProductId(Long productId);

    void deleteByProductId(Long productId);

    boolean existsByProductId(Long productId);

}
