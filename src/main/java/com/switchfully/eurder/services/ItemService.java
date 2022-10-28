package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.repositories.ItemRepository;
import com.switchfully.eurder.domain.dto.itemdto.ItemDto;
import com.switchfully.eurder.domain.dto.itemdto.ItemMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ItemService {
    ItemRepository itemRepository;
    ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.itemMapper = new ItemMapper();
    }

    public ItemDto addItem(ItemDto itemDto) {
        Item newItem = itemMapper.itemDtoToItem(itemDto);
        checkNameAndDescriptionFields(itemDto);
        itemRepository.save(newItem);
        return itemDto;
    }

    private void checkNameAndDescriptionFields(ItemDto itemDto) {
        if (itemDto.getName() == null || itemDto.getName().equals("")) {
            throw new IllegalArgumentException("Provide a Name please!");
        }
        if (itemDto.getDescription() == null || itemDto.getDescription().equals("")) {
            throw new IllegalArgumentException("Provide a description please!");
        }
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public LocalDate calculateShippingDate(String itemId, int amount) {
        Item item = itemRepository.getItemDatabase().get(itemId);
        if (item.getAmount() - amount < 0) {
            return LocalDate.now().plusDays(7);
        }
        return LocalDate.now().plusDays(1);
    }

    public double calculatePrice(String itemId, int amount){
        Item item = itemRepository.getItemDatabase().get(itemId);
        return item.getPrice() * amount;
    }

    /**
    public static void main(String[] args) {
        new ItemService(new ItemRepository());
    }
     */
}

