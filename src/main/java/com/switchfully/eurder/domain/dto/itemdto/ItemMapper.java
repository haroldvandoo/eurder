package com.switchfully.eurder.domain.dto.itemdto;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.repositories.ItemRepository;

public class ItemMapper {
    public Item itemDtoToItem(ItemDto itemDto) {
        return new Item(itemDto.getName(), itemDto.getDescription(), itemDto.getPrice(), itemDto.getAmount());
    }
}
