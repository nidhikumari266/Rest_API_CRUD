package com.revision.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.revision.models.Product;
import com.revision.services.ProductService;



@RestController
@RequestMapping("Product-Service")
public class ProductController 
{
    @Autowired private ProductService productService;
    @PostMapping("product/create")
	public ResponseEntity<Product> createMessage(@RequestBody Product product)
	{
    	productService.saveMessage(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
    
    //   http://localhost:8080/Product-Service/Product/delete?pid=103
    //delete
    @DeleteMapping("Product/delete")
	public ResponseEntity<Product> deleteStudentInfo(@RequestParam int pid)
	{
		Product  product=productService.getDetails(pid);
		if(product==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		productService.deleteByPid(pid);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
    //  http://localhost:8080/Product-Service/Product/list
    @GetMapping("Product/list")
	public ResponseEntity<List<Product>> getProductList()
	{
		List<Product> list = productService.getList();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
    
    //update -------handler
    //  http://localhost:8080/Product-Service/product/edit/104
    @PatchMapping("product/edit/{pid}")
	public ResponseEntity<Product> editProduct(@PathVariable int pid,@RequestBody Product productn)
	{
		Product producto = productService.getDetails(pid);
		if(producto==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		productService.updateProduct(pid,producto,productn);
		return ResponseEntity.status(HttpStatus.OK).body(producto);
	}
}
