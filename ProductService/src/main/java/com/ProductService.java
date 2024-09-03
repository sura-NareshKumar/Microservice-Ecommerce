package com;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	
	@Autowired
	CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    
    
    public List<Product> getProductsByCategory(String categoryName) {
        Optional<Category> categoryOpt = categoryRepository.findByName(categoryName);
        if (categoryOpt.isPresent()) {
            return productRepository.findByCategory(categoryOpt.get());
        } else {
            throw new IllegalArgumentException("Category with name " + categoryName + " does not exist");
        }
    }
}