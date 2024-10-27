package com.unicauca.my_food_order.infrastructure.input.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.unicauca.my_food_order.application.input.ManageOrderUCIntPort;
import com.unicauca.my_food_order.application.output.MapperOrderInfrastructureDomainIntPort;
import com.unicauca.my_food_order.domain.Order;
import com.unicauca.my_food_order.infrastructure.input.controller.DTOResponse.OrderDTOResponse;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final ManageOrderUCIntPort orderUC;
    private final MapperOrderInfrastructureDomainIntPort mapper;

    @GetMapping("")
    public ResponseEntity<List<OrderDTOResponse>> index(){
        List<Order> orders = this.orderUC.getOrders();
        
        return new ResponseEntity<List<OrderDTOResponse>>(
            this.mapper.mapModelToResponse(orders), HttpStatus.OK);
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<OrderDTOResponse> findOrderById(@PathVariable String idOrder){
        Order orders = this.orderUC.getOrder(idOrder);
        
        return new ResponseEntity<OrderDTOResponse>(
            this.mapper.mapModelToResponse(orders), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<OrderDTOResponse> createOrder(){
        Order order = this.orderUC.createOrder();
        return new ResponseEntity<OrderDTOResponse>(
            this.mapper.mapModelToResponse(order), HttpStatus.CREATED);
    }

    @PatchMapping("/dishes/{idOrder}")
    public ResponseEntity<OrderDTOResponse> addDishToOrder(@PathVariable String idOrder, 
                                                @RequestParam String dishName, 
                                                @RequestParam double dishValue){
        Order order = this.orderUC.addDish(idOrder, dishName, dishValue);
        return new ResponseEntity<OrderDTOResponse>(
            this.mapper.mapModelToResponse(order), HttpStatus.OK);
    }

    @DeleteMapping("/dishes/{idOrder}/{idDish}")
    public ResponseEntity<OrderDTOResponse> removeDishToOrder(@PathVariable String idOrder, 
                                                @PathVariable String idDish){
        Order order = this.orderUC.removeDish(idOrder, idDish);
        return new ResponseEntity<OrderDTOResponse>(
            this.mapper.mapModelToResponse(order), HttpStatus.OK);
    }
    
    @PutMapping("/{idOrder}/{state}")
    public ResponseEntity<OrderDTOResponse> updateOrderState(@PathVariable String idOrder, 
                                                @PathVariable int state){
        Order order = this.orderUC.updateOrderState(idOrder, state);
        return new ResponseEntity<OrderDTOResponse>(
            this.mapper.mapModelToResponse(order), HttpStatus.OK);
    }

    @PostMapping("/{idOrder}")
    public ResponseEntity<Double> calculateOrderTotalPrice(@PathVariable String idOrder){
        double totalPrice = this.orderUC.calculateOrderTotalPrice(idOrder);
        return new ResponseEntity<>(totalPrice,HttpStatus.OK);
    }

}
