package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.dto.orderdto.OrderDto;
import com.switchfully.eurder.domain.dto.orderdto.OrderMapper;
import com.switchfully.eurder.exceptions.all.NonExistingUserException;
import com.switchfully.eurder.repositories.ItemRepository;
import com.switchfully.eurder.repositories.OrderRepository;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.security.Role;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    UserRepository userRepository;
    ItemRepository itemRepository;


    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderMapper = new OrderMapper();
        this.itemRepository = itemRepository;
    }

    //todo need to add total price
    public OrderDto createOrder(Long customerId, double totalPrice) {
        validateCustomerId(customerId);
        Order order = orderMapper.createOrderDtoToOrder(customerId, totalPrice);
        orderRepository.save(order);
        return orderMapper.orderToDto(order);
    }

    private void validateCustomerId(Long customerId) {
        if (!userRepository.findById(customerId).orElseThrow().getRole().equals(Role.CUSTOMER)) {
            throw new NonExistingUserException();
        }
    }
}
