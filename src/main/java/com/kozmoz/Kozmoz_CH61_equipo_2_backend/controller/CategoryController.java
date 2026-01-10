package com.kozmoz.Kozmoz_CH61_equipo_2_backend.controller;


import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Category;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //GET - Todas las categorías
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //GET - Categoría por ID
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    //POST - Crear categoría
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    //PUT - Actualizar categoría
    @PutMapping("/{id}")
    public Category updateCategory(
            @PathVariable Integer id,
            @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    // DELETE - Eliminar categoría
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
