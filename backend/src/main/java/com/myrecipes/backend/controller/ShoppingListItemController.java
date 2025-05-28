package com.myrecipes.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrecipes.backend.dto.ShoppingListItemDTO;
import com.myrecipes.backend.service.ShoppingListItemService;

@RestController
@RequestMapping("/api/shopping-list-items")
@CrossOrigin(origins = "*")
public class ShoppingListItemController {

    private final ShoppingListItemService service;

    public ShoppingListItemController(ShoppingListItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<ShoppingListItemDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ShoppingListItemDTO save(@RequestBody ShoppingListItemDTO item) {
        return service.save(item);
    }

    @GetMapping("/shopping-list/{shoppingListId}")
    public List<ShoppingListItemDTO> getByShoppingListId(@PathVariable Long shoppingListId) {
        return service.getByShoppingListId(shoppingListId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
