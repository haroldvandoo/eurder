package com.switchfully.eurder.domain.dto.orderdto;

import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.domain.dto.ItemGroupDto.ItemGroupMapper;

public class OrderMapper {
    ItemGroupMapper itemGroupMapper = new ItemGroupMapper();
    public Order orderDtoToOrder(OrderDto orderDto) {
        return new Order(itemGroupMapper.itemGroupDtoToItemGroupList(orderDto.getItemGroupDtoList()), orderDto.getPhoneNumber());
    }
}
