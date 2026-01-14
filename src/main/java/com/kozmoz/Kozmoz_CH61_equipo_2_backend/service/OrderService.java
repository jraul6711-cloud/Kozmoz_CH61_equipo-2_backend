package com.kozmoz.Kozmoz_CH61_equipo_2_backend.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Order;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }//List

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }//getOrder

    public Order addOrder(Order order) {
        // id debe venir null para crear
        order.setId(null);
        return orderRepository.save(order);
    }//addOrder

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }//deleteOrder

    // Actualización parcial
    public Order updateOrder(Long id, LocalDateTime orderDate, Float total) {
        Order existing = getOrder(id);

        if (orderDate != null) existing.setOrderDate(orderDate);
        if (total != null) existing.setTotal(total);

        return orderRepository.save(existing);
    }//updateOrder
}//OrderService

