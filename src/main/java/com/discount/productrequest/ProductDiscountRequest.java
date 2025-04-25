package com.discount.productrequest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDiscountRequest {
    private String productId;
    private String discountType;
    private double discountValue;
    private boolean seasonalDiscountActive;
    private double productPrice;
    private int quantity;
    
}