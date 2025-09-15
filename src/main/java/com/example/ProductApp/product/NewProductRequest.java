package com.example.ProductApp.product;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
public record NewProductRequest(
        @NotBlank
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
        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.1" , message = "Price must be greater that 0.1")
        BigDecimal price,
        @NotNull(message = "stockLevel is required")
        @Min(value =1, message = "stockLevel must be greater that 0")
        Integer stockLevel,
        String imageUrl) {

}
