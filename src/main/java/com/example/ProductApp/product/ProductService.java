package com.example.ProductApp.product;

import com.example.ProductApp.exception.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElseThrow(()-> new ResourceNotFound(
                "Product with id [" + id + "] not found"
        ));
    }

    public void deleteProductById(UUID id) {
        boolean exists = productRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFound("Product with id [" + id + "] not found");
        }
        productRepository.deleteById(id);
    }

    public UUID saveNewProduct(NewProductRequest product) {
      UUID id = UUID.randomUUID();
      Product newProduct = new Product(
              id,product.name(),
              product.description(),
              product.price(),
              product.imageUrl(),
              product.stockLevel());
      productRepository.save(newProduct);
      return id;
    }
}
