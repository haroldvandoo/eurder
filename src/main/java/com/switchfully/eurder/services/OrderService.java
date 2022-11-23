package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.dto.ItemGroupDto.CreateItemGroupDto;
import com.switchfully.eurder.domain.dto.orderdto.OrderDto;
import com.switchfully.eurder.domain.dto.orderdto.OrderMapper;
import com.switchfully.eurder.exceptions.all.NonExistingUserException;
import com.switchfully.eurder.repositories.ItemRepository;
import com.switchfully.eurder.repositories.OrderRepository;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.security.Role;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    UserRepository userRepository;
    ItemRepository itemRepository;

    ItemGroupService itemGroupService;


    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ItemRepository itemRepository, ItemGroupService itemGroupService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderMapper = new OrderMapper();
        this.itemRepository = itemRepository;
        this.itemGroupService = itemGroupService;
    }

    public OrderDto createOrder(Long customerId, double totalPrice) {
        validateCustomerId(customerId);
        Order order = orderMapper.createOrderDtoToOrder(customerId, totalPrice);
        orderRepository.save(order);
        return orderMapper.orderToDto(order);
    }

    public OrderDto createOrder(Long customerId, List<CreateItemGroupDto> createItemGroupDtoList) {
        validateCustomerId(customerId);
        double totalPrice = itemGroupService.calculatePriceOfAllItems(createItemGroupDtoList);
        Order order = orderMapper.createOrderDtoToOrder(customerId, totalPrice);
        orderRepository.save(order);
        long orderId = order.getId();
        itemGroupService.createItemGroupList(createItemGroupDtoList, orderId);
        return orderMapper.orderToDto(order);
    }

    private void validateCustomerId(Long customerId) {
        if (!userRepository.findById(customerId).orElseThrow().getRole().equals(Role.CUSTOMER)) {
            throw new NonExistingUserException();
        }
    }
}
