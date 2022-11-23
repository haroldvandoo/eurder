package com.switchfully.eurder.domain;

import io.swagger.v3.oas.annotations.tags.Tags;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
/**
@Entity
@Table(name = "order_by_client")
public class OrderByClient {

    private Long orderId;
    private Long customerId;

    public OrderByClient() {
    }

    public OrderByClient(Long orderId, Long customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }




}
 */
