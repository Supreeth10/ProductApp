package com.example.ProductApp.product;

import java.math.BigDecimal;
public record NewProductRequest(String name,
                                String description,
                                BigDecimal price,
                                Integer stockLevel,
                                String imageUrl) {

}
