package com.kozmoz.Kozmoz_CH61_equipo_2_backend.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders") 
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private Float total;

    //Constructor 
    public Order() {}

    public Order(LocalDateTime orderDate, Float total) {
        this.orderDate = orderDate;
        this.total = total;
    }//Order

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public Float getTotal() { return total; }
    public void setTotal(Float total) { this.total = total; }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderDate=" + orderDate + ", total=" + total + "]";
    }//toString
}//Order

