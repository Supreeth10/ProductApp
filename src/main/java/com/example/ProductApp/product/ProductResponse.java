package com.example.ProductApp.product;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record ProductResponse(UUID id,
                              String name,
                              String description,
                              BigDecimal price,
                              Integer stockLevel,
                              String imageUrl,
                              Instant createdAt,
                              Instant updatedAt,
                              Instant deletedAt) {
}
