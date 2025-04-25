package com.discount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discount.domain.Product;
import com.discount.productrequest.ProductDiscountRequest;
import com.discount.service.ProductService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	
   //http://localhost:9092/api/products/discount
	
    @Autowired
    private ProductService productService;

    @PostMapping("/discount")
    public ResponseEntity<Product> applyDiscount(@Valid @RequestBody ProductDiscountRequest request) {
        return ResponseEntity.ok(productService.applyDiscount(request));
    }
    
    // http://localhost:9092/api/products/8215d218-9148-4a1c-94b3-1456f0a1b53a
    
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }
}