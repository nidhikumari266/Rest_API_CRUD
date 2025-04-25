package com.discount.service;

import com.discount.domain.Product;
import com.discount.productrequest.ProductDiscountRequest;

public interface ProductService {

	Product applyDiscount(ProductDiscountRequest request);

	Product getProduct(String productId);

}
