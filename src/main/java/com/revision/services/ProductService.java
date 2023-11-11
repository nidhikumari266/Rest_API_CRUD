package com.revision.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revision.models.Product;
import com.revision.repositories.ProductRepo;

@Service
public class ProductService 
{
    @Autowired private ProductRepo productRepo;
	public void saveMessage(Product product) 
	{
		productRepo.save(product);
	}
	//-----select then delete
	public Product getDetails(int pid)
	{
		Product product = productRepo.findById(pid).orElse(null);
		return product;
	}
	
	public void deleteByPid(int pid)
	{
		productRepo.deleteById(pid); 	
	}
	
	//select
	public List<Product> getList() {
		return productRepo.findAll();
	}
	//update ----first get data and then set
	public void updateProduct(int pid, Product producto, Product productn) 
	{
		if(productn.getName()!=null)
			producto.setName(productn.getName());
		if(productn.getQuantity()!=0)
			producto.setQuantity(productn.getQuantity());
		if(productn.getPrice()!=0)
			producto.setPrice(productn.getPrice());
		productRepo.save(producto);
	}
}
