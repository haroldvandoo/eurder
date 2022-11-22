package com.switchfully.eurder.controllers;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.domain.ItemGroup;
import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.dto.ItemGroupDto.ItemGroupDto;
import com.switchfully.eurder.domain.dto.ItemGroupDto.ItemGroupMapper;
import com.switchfully.eurder.domain.dto.itemdto.ItemDto;
import com.switchfully.eurder.domain.dto.orderdto.OrderDto;
import com.switchfully.eurder.domain.dto.orderdto.OrderMapper;
import com.switchfully.eurder.services.ItemService;
import com.switchfully.eurder.services.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private OrderController orderController;

    @Autowired
    private OrderService orderService;

    private ItemGroupMapper itemGroupMapper = new ItemGroupMapper();


    @Test
    void createOrderAsRegisteredUser_HappyPath() {
        //given

        ItemDto item1 = new ItemDto("1", "sofa", "Ikea sofa", 200, 20);
        ItemDto item2 = new ItemDto("2", "Coffee table", "beautiful coffee table", 2000, 50);

        ItemGroupDto itemGroupDto1 = new ItemGroupDto(item1, 5);
        ItemGroupDto itemGroupDto2 = new ItemGroupDto(item2, 3);

        List<ItemGroupDto> itemGroupList1 = Arrays.asList(itemGroupDto1, itemGroupDto2);

        OrderDto orderDtoDummy = new OrderDto(itemGroupList1, "02456789120");

        Order order = new Order(orderDtoDummy.getId(), itemGroupMapper.itemGroupDtoToItemGroupList(orderDtoDummy.getItemGroupDtoList()), orderDtoDummy.getPhoneNumber());

        //when
        OrderDto addedOrderDto = orderController.createOrder("Basic MDI0NTY3ODkxMjA6cGFzc3dvcmQ=", orderDtoDummy, "02456789120");

        //then
        Assertions.assertTrue(orderService.getOrderRepository().getOrderDatabase().values().stream().filter(anOrder -> anOrder.getPhoneNumber().equals("02456789120")).findFirst().orElseThrow().getPhoneNumber().equals("02456789120"));


    }


}
