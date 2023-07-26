package com.Application.Inventory.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Application.Inventory.Service.ProductService;
import com.Application.Inventory.Vo.ProductVo;
import com.Application.Inventory.Vo.UpdateVo;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/add-products")
	public String addProducts(@RequestBody List<ProductVo> productVo) {
		return productService.addProducts(productVo);
	}

	@GetMapping("/get-products")
	public String getProducts() {
		return "";
	}

	@PostMapping("/update-product")
	public String updateProduct(@RequestBody UpdateVo updateVo) {
		return productService.updateProduct(updateVo);
	}

	@DeleteMapping("/delete-product")
	public String deleteProduct(@RequestParam Long productId) {
		return productService.deleteProduct(productId);
	}
}