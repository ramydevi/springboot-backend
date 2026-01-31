package com.shopping.shoppinglist.controller;

import com.shopping.shoppinglist.entity.ShoppingItem;
import com.shopping.shoppinglist.repository.ShoppingItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ShoppingItemController {

    private final ShoppingItemRepository repository;

    // Constructor injection
    public ShoppingItemController(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    // CREATE - Add new item
    @PostMapping
    public ShoppingItem addItem(@RequestBody ShoppingItem item) {
        return repository.save(item);
    }

    // READ - Get all items
    @GetMapping
    public List<ShoppingItem> getAllItems() {
        return repository.findAll();
    }

    // READ - Get single item by ID
    @GetMapping("/{id}")
    public ShoppingItem getItemById(@PathVariable Long id) {
        Optional<ShoppingItem> item = repository.findById(id);
        return item.orElse(null);
    }

    // UPDATE - Update an existing item
    @PutMapping("/{id}")
    public ShoppingItem updateItem(@PathVariable Long id, @RequestBody ShoppingItem updatedItem) {
        return repository.findById(id)
                .map(item -> {
                    item.setItemName(updatedItem.getItemName());
                    item.setQuantity(updatedItem.getQuantity());
                    item.setPrice(updatedItem.getPrice());
                    return repository.save(item);
                })
                .orElse(null);
    }

    // DELETE - Delete item by ID
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // DELETE - Delete ALL items
    @DeleteMapping
    public void deleteAllItems() {
        repository.deleteAll();
    }
}
