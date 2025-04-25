package com.discount.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discount.domain.Product;
import com.discount.productrequest.ProductDiscountRequest;
import com.discount.repository.ProductRepository;
import com.discount.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

    public Product applyDiscount(ProductDiscountRequest request) {
    	String id = UUID.randomUUID().toString();
    	request.setProductId(id);
        if (request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Product is out of stock");
        }

        double price = request.getProductPrice();
        double discountAmount = 0;

        switch (request.getDiscountType().toLowerCase()) {
            case "percentage":
                discountAmount = price * (request.getDiscountValue() / 100);
                break;
            case "flat":
                discountAmount = request.getDiscountValue();
                break;
            default:
                throw new IllegalArgumentException("Invalid discount type");
        }

        if (request.isSeasonalDiscountActive()) {
            discountAmount += price * 0.25; 
        }

        double finalPrice = price - discountAmount;
        if (finalPrice < 0) finalPrice = 0;

        Product product = Product.builder()
                .productId(request.getProductId())
                .productPrice(price)
                .discountType(request.getDiscountType())
                .discountValue(request.getDiscountValue())
                .seasonalDiscountActive(request.isSeasonalDiscountActive())
                .quantity(request.getQuantity())
                .finalPrice(finalPrice)
                .build();

        return productRepository.save(product);
    }

    public Product getProduct(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }
}
