package com.Application.Inventory.Repositories;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Application.Inventory.Entity.ProductEntity;

@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByProductId(Long productId);

    void deleteByProductId(Long productId);

    boolean existsByProductId(Long productId);

    @Query(value = "SELECT * FROM product ORDER BY 1 LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<ProductEntity> getProductsByOffset(int limit, int offset);
}
