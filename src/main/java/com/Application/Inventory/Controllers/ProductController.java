package com.Application.Inventory.Controllers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductController{
	
	@PostMapping("/add-products")
	public String addProducts() {
		return "Test";
	}
	@GetMapping("/get-products")
	public String getProducts() {
		return "";
	}
	@PostMapping("/update-products")
	public String updateProduct() {
		return "";
	}
	@DeleteMapping("/delete-product")
	public String deleteProduct() {
		return "";
	}
}