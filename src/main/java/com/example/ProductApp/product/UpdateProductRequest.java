package com.example.ProductApp.product;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record UpdateProductRequest(

        @Size(
                min = 2,
                max = 50,
                message = "Name must be between 2 and 50")
        String name,
        @Size(
                min = 2,
                max = 500,
                message = "description must be between 2 and 50")
        String description,
        String imageUrl,
        @DecimalMin(value = "0.1" , message = "Price must be greater that 0.1")
        BigDecimal price,
        @Min(value =1, message = "stockLevel must be greater that 0")
        Integer stockLevel) {
}
