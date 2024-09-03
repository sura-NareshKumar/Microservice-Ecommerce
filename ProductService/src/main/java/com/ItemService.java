// ItemService.java
package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Item> getItemsByCategory(String category) {
        return itemRepository.findByCategoryName(category);
    }
}
