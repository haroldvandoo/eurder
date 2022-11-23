package com.switchfully.eurder.domain.dto.orderdto;

import com.switchfully.eurder.domain.dto.ItemGroupDto.ItemGroupDto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class OrderDto {
    private Long id;

    private Double price;

    private Long customerId;

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public OrderDto(Long id, Double price, Long customerId) {
        this.id = id;
        this.price = price;
        this.customerId = customerId;
    }
}
