package com.Application.Inventory.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Application.Inventory.Entity.ProductEntity;
import com.Application.Inventory.Repositories.ProductRepository;
import com.Application.Inventory.Vo.ProductVo;
import com.Application.Inventory.Vo.ResponseVo;
import com.Application.Inventory.Vo.UpdateVo;

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

    public String updateProduct(UpdateVo updateVo) {
        try {
            if (Objects.nonNull(updateVo) && updateVo.isAdmin()) {
                ProductEntity productEntity = productRepository.findByProductId(updateVo.getProductId());
                productEntity.setDescription(updateVo.getDescription());
                productEntity.setName(updateVo.getName());
                productEntity.setPrice(updateVo.getPrice());
                productEntity.setQuantity(updateVo.getQuantity());
                productRepository.save(productEntity);
                return "Success";
            } else {
                return "You are not authorized";
            }
        } catch (Exception e) {
            System.out.println("Product Update Failed :" + e);
        }
        return "fail";
    }

    public String deleteProduct(Long productId) {
        try {
            if (productRepository.existsById(productId)) {
                productRepository.deleteById(productId);
                return "Deleted Successully";
            } else {
                return "Product does not exists";
            }
        } catch (Exception e) {
            System.out.println("Product Delete Failed " + e);
            return "Product Delete failed";
        }
    }

    public ResponseVo getProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            ProductEntity productEntity = productRepository.findByProductId(productId);
            return ResponseVo.builder()
                    .productId(productEntity.getProductId())
                    .name(productEntity.getName())
                    .description(productEntity.getDescription())
                    .quantity(productEntity.getQuantity())
                    .price(productEntity.getPrice())
                    .build();
        } else {
            return null;
        }
    }

    public List<ProductEntity> getProducts(int limit, int pageNo){
        int offset=(pageNo-1)*limit;
        List<ProductEntity> productList = productRepository.getProductsByOffset(limit, offset);
        return productList;
    }
}