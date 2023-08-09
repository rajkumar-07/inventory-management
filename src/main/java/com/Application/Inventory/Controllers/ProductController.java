package com.Application.Inventory.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Application.Inventory.Entity.ProductEntity;
import com.Application.Inventory.Service.ProductService;
import com.Application.Inventory.Vo.ProductVo;
import com.Application.Inventory.Vo.ResponseVo;
import com.Application.Inventory.Vo.UpdateVo;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/add-products")
	@ResponseStatus(HttpStatus.OK)
	public String addProducts(@RequestBody List<ProductVo> productVo) {
		return productService.addProducts(productVo);
	}

	@GetMapping("/get-product")
	public ResponseVo getProducts(@RequestParam Long productId) {
		return productService.getProduct(productId);
	}

	@PostMapping("/update-product")
	public String updateProduct(@RequestBody UpdateVo updateVo) {
		return productService.updateProduct(updateVo);
	}

	@DeleteMapping("/delete-product")
	public String deleteProduct(@RequestParam Long productId) {
		return productService.deleteProduct(productId);
	}

	@PostMapping("/get-products")
	public List<ProductEntity> loadProducts(@RequestParam int limit,@RequestParam int offset){	
		return productService.getData(limit,offset);
	}
}