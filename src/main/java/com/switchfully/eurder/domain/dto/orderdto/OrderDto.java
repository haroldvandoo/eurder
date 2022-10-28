package com.switchfully.eurder.domain.dto.orderdto;

import com.switchfully.eurder.domain.dto.ItemGroupDto.ItemGroupDto;

import java.util.List;
import java.util.UUID;

public class OrderDto {
    private String id;
    private List<ItemGroupDto> itemGroupDtoList;

    private String phoneNumber;

    public String getId() {
        return id;
    }

    public List<ItemGroupDto> getItemGroupDtoList() {
        return itemGroupDtoList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderDto(List<ItemGroupDto> itemGroupDtoList, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.itemGroupDtoList = itemGroupDtoList;
        this.phoneNumber = phoneNumber;
    }
}
