package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.domain.dto.itemdto.CreateItemDto;
import com.switchfully.eurder.domain.dto.itemdto.ItemDto;
import com.switchfully.eurder.domain.dto.itemdto.ItemMapper;
import com.switchfully.eurder.repositories.ItemRepository;
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

    public ItemDto addItem(CreateItemDto createItemDto) {
        Item newItem = itemMapper.createItemDtoToItem(createItemDto);
        checkNameAndDescriptionFields(createItemDto);
        itemRepository.save(newItem);
        return itemMapper.itemToItemDto(newItem);
    }

    private void checkNameAndDescriptionFields(CreateItemDto createItemDto) {
        if (createItemDto.getName() == null || createItemDto.getName().equals("")) {
            throw new IllegalArgumentException("Provide a Name please!");
        }
        if (createItemDto.getDescription() == null || createItemDto.getDescription().equals("")) {
            throw new IllegalArgumentException("Provide a description please!");
        }
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public LocalDate calculateShippingDate(Long itemId, int amount) {
        Item item = itemRepository.getReferenceById(itemId);
        if (item.getAmount() - amount < 0) {
            return LocalDate.now().plusDays(7);
        }
        return LocalDate.now().plusDays(1);
    }

    public double calculatePrice(Long itemId, int amount){
        Item item = itemRepository.getReferenceById(itemId);
        return item.getPrice() * amount;
    }
}

