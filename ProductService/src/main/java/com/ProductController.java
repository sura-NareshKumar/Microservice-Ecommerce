package com;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{category}")
    public List<Product> getProductById(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    
    
 

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return itemService.getAllCategories();
    }

    @GetMapping("/items")
    public List<Item> getItemsByCategory(@RequestParam String category) {
        return itemService.getItemsByCategory(category);
    }
}