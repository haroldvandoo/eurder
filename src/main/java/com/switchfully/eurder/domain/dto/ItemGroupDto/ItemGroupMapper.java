package com.switchfully.eurder.domain.dto.ItemGroupDto;

import com.switchfully.eurder.domain.ItemGroup;

import java.util.List;
import java.util.stream.Collectors;

public class ItemGroupMapper {

    public ItemGroup itemGroupDtoToItemGroup(ItemGroupDto itemGroupDto) {
        return new ItemGroup(itemGroupDto.getId(), itemGroupDto.getAmount(), itemGroupDto.getShippingDate(), itemGroupDto.getPrice());
    }

    public List<ItemGroup> itemGroupDtoToItemGroupList (List<ItemGroupDto> itemGroupDtoList) {
        return itemGroupDtoList.stream().map(itemGroupDto -> itemGroupDtoToItemGroup(itemGroupDto)).collect(Collectors.toList());
    }


}
