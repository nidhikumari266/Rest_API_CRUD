package com.discount.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String productId;

    @Min(value = 0, message = "Price must be non-negative")
    private double productPrice;

    @Min(value = 1, message = "Quantity must be greater than zero")
    private int quantity;

    private boolean seasonalDiscountActive;

    private String discountType; // "flat" or "percentage"

    @PositiveOrZero(message = "Discount value must be positive or zero")
    private double discountValue;

    private double finalPrice;
}