package com.Application.Inventory.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Application.Inventory.Entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByProductId(Long productId);

    void deleteByProductId(Long productId);

    boolean existsByProductId(Long productId);

    @Query(value = "SELECT * FROM product ORDER BY id LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<ProductEntity> getData(int limit, int offset);
}
