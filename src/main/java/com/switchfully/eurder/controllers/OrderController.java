package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.dto.itemdto.ItemDto;
import com.switchfully.eurder.domain.dto.orderdto.OrderDto;
import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.services.OrderService;
import com.switchfully.eurder.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    OrderService orderService;
    SecurityService securityService;

    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestHeader String authorization, @RequestBody OrderDto orderDto, @RequestBody String phoneNumber) {
        log.info("the following order is being processes: " + orderDto + "for user with the phone number: "+ phoneNumber);
        securityService.validateAuthorization(authorization, Feature.CREATE_ORDER);
        System.out.println(orderService.calculatePriceOfOrder(orderDto));
        return orderService.createOrder(orderDto, phoneNumber);
    }

}
