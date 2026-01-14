package com.kozmoz.Kozmoz_CH61_equipo_2_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
}//OrderRepository
