package com.unicauca.my_food_order.infrastructure.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unicauca.my_food_order.infrastructure.output.persistence.entities.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String>{
    
}
