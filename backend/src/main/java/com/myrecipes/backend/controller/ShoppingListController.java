package com.myrecipes.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrecipes.backend.dto.ShoppingListDTO;
import com.myrecipes.backend.entity.ShoppingList;
import com.myrecipes.backend.service.ShoppingListService;

@RestController
@RequestMapping("/api/shopping-lists")
@CrossOrigin(origins = "*")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping
    public List<ShoppingListDTO> getAll() {
        return shoppingListService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ShoppingListDTO> getById(@PathVariable Long id) {
        return shoppingListService.getById(id);
    }

    @PostMapping
    public ShoppingListDTO save(@RequestBody ShoppingList list) {
        return shoppingListService.save(list);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        shoppingListService.delete(id);
    }
}
