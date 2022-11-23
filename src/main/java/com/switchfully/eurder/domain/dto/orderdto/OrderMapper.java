package com.switchfully.eurder.domain.dto.orderdto;

import com.switchfully.eurder.domain.Order;

public class OrderMapper {
    public Order createOrderDtoToOrder(Long customerId, double totalPrice) {
        return new Order(customerId, totalPrice);
    }

    public OrderDto orderToDto(Order order) {
        return new OrderDto(order.getId(), order.getPrice(), order.getCustomerId());
    }


    /**
    public Order createOrderDtoToOrder(CreateOrderDto createOrderDto){
        return new Order(createOrderDto.getItemId(), createOrderDto.getAmount(), createOrderDto.getCustomerId());
    }

    public OrderDto orderToDto(Order order) {
        return new OrderDto(order.getId(), order.getItemId(), order.getAmount(), order.getShippingDate(), order.getPrice(), order.getCustomerId());
    }
     */
}
