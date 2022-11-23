package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.dto.ItemGroupDto.CreateItemGroupDto;
import com.switchfully.eurder.domain.dto.orderdto.OrderDto;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.services.ItemGroupService;
import com.switchfully.eurder.services.OrderService;
import com.switchfully.eurder.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    OrderService orderService;
    ItemGroupService itemGroupService;

    SecurityService securityService;

    public OrderController(OrderService orderService, ItemGroupService itemGroupService, SecurityService securityService) {
        this.orderService = orderService;
        this.itemGroupService = itemGroupService;
        this.securityService = securityService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(
            @RequestHeader String authorization,
            @RequestBody List<CreateItemGroupDto> createItemGroupDtoList){
        log.info("the following order is being processes: " + createItemGroupDtoList);
        securityService.validateAuthorization(authorization, Feature.CREATE_ORDER);
        double totalPrice = itemGroupService.createItemGroupList(createItemGroupDtoList);
        Long customerId = Long.valueOf(securityService.getUsernamePassword(authorization).getUsername());
        return orderService.createOrder(customerId, totalPrice);
    }
}
