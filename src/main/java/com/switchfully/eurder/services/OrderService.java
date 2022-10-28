package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.dto.orderdto.OrderDto;
import com.switchfully.eurder.domain.dto.orderdto.OrderMapper;
import com.switchfully.eurder.exceptions.all.NonExistingUserException;
import com.switchfully.eurder.repositories.OrderRepository;
import com.switchfully.eurder.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;

    UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderMapper = new OrderMapper();
    }

    public OrderDto createOrder(OrderDto orderDto, String phoneNumber) {
        Order order = orderMapper.orderDtoToOrder(orderDto);
        /**
        if (!userRepository.getUserDatabase().contains(phoneNumber)) {
            throw new NonExistingUserException();
        }*/
        orderRepository.save(order);
        return orderDto;
    }

    public double calculatePriceOfOrder(OrderDto orderDto) {
       List<Double> listOfPrices = orderDto.getItemGroupDtoList().stream().map(itemGroupDto -> itemGroupDto.getPrice()).collect(Collectors.toList());
       return listOfPrices.stream().reduce(0.0, (a, b) -> a + b);
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    /**

    public static void main(String[] args) {
        OrderService orderService = new OrderService(new OrderRepository(), new UserRepository());
    }
     */


}
