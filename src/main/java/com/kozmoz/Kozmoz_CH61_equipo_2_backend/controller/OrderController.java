package com.kozmoz.Kozmoz_CH61_equipo_2_backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Order;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }//OrderController

    // GET /api/orders
    @GetMapping
    public List<Order> getOrders() {
        return service.getAllOrders();
    }//List

    // GET /api/orders/{orderId}
    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return service.getOrder(orderId);
    }//getOrder

    // POST /api/orders
    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return service.addOrder(order);
    }//addOrder

    // DELETE /api/orders/{orderId}
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        service.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }//ResponseEntity

    // PATCH /api/orders/{orderId}?fecha=...&total=...
    @PatchMapping("/{orderId}")
    public Order updateOrder(
            @PathVariable Long orderId,
            @RequestParam(name = "fecha", required = false) java.time.LocalDateTime orderDate,
            @RequestParam(name = "total", required = false) Float total
    ) {
        return service.updateOrder(orderId, orderDate, total);
    }
}//OrderController
