package com.example.ProductApp.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") UUID id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") UUID id) {
        productService.deleteProductById(id);
    }

    @PostMapping
    public UUID saveProduct(@RequestBody NewProductRequest product) {
       return productService.saveNewProduct(product);
    }
}
