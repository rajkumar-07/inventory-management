package com.Application.Inventory.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Application.Inventory.Entity.ProductEntity;
import com.Application.Inventory.Repositories.ProductRepository;
import com.Application.Inventory.Vo.ProductVo;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProducts(List<ProductVo> productVo) {
        try {
            if (Objects.nonNull(productVo)) {
                for (ProductVo product : productVo) {
                    ProductEntity productEntity = ProductEntity.builder().name(product.getName())
                            .description(product.getDescription()).quantity(product.getQuantity())
                            .price(product.getPrice()).build();
                    productRepository.save(productEntity);
                }

                return "Success";
            }
        } catch (Exception e) {
            System.out.println("Product Add fail" + e);
        }
        return "fail";
    }
}