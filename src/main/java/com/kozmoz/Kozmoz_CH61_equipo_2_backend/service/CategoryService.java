package com.kozmoz.Kozmoz_CH61_equipo_2_backend.service;


import com.kozmoz.Kozmoz_CH61_equipo_2_backend.repository.CategoryRepository;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // GET - Obtener todas las categorías
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // GET - Obtener categoría por ID
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    // POST - Crear categoría
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // PUT - Actualizar categoría
    public Category updateCategory(Integer id, Category category) {
        category.setIdCategory(id);
        return categoryRepository.save(category);
    }

    // DELETE - Eliminar categoría
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}//CategoryService

