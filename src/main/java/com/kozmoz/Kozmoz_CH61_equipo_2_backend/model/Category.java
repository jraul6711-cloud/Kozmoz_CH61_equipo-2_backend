package com.kozmoz.Kozmoz_CH61_equipo_2_backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategory")
    private Integer idCategory;

    @Column(name = "names", nullable = false, length = 45)
    private String names;

    //  Constructor vacío
    public Category() {
    }

    // Constructor con propiedades
    public Category(Integer idCategory, String names) {
        this.idCategory = idCategory;
        this.names = names;
    }

    // Getters y Setters
    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}

