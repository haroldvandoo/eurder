package com.switchfully.eurder.domain.dto.ItemGroupDto;

import com.switchfully.eurder.domain.ItemGroup;

public class ItemGroupMapper {
    public ItemGroup createIGDtoIG(CreateItemGroupDto createItemGroupDto) {
        return new ItemGroup(createItemGroupDto.getItemId(),createItemGroupDto.getAmount());
    }

    public ItemGroupDto itemGroupToDto(ItemGroup itemGroup) {
return new ItemGroupDto(itemGroup.getId(), itemGroup.getAmount(), itemGroup.getShippingDate(), itemGroup.getPrice(), itemGroup.getOrderId());
    }
}
