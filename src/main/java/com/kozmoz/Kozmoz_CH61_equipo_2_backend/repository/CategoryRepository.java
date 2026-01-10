package com.kozmoz.Kozmoz_CH61_equipo_2_backend.repository;


import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Category;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.repository.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
