package com.switchfully.eurder.domain;

import com.switchfully.eurder.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
    private Long id;

    @Column(name = "price")
    private Double price;

    //@ManyToOne
    @Column(name = "customer_id")
    private Long customerId;


    public Order() {
    }

    public Order(Long customerId) {
        this.customerId = customerId;
    }

    public Order(Long customerId, double price) {
        this.customerId = customerId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }
    public long getCustomerId() {
        return customerId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
