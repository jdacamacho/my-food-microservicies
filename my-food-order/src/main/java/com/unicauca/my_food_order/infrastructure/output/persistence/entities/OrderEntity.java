package com.unicauca.my_food_order.infrastructure.output.persistence.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
public class OrderEntity {
    @Id
    @Column(length = 200)
    private String id_order;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "objOrder")
    @JoinColumn(name = "id_date")
    private OrderDateEntity date;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "objOrder")
    @JoinColumn(name = "id_state")
    private OrderStateEntity state;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "order_dish",
        joinColumns = @JoinColumn(name = "id_order"),
        inverseJoinColumns = @JoinColumn(name = "id_dish")
    )
    private List<DishEntity> dishes;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "objOrder")
    @JoinColumn(name = "id_total_price")
    private TotalPriceEntity totalPrice; 

    public OrderEntity(){
        this.dishes = new ArrayList<>();
    }
}
