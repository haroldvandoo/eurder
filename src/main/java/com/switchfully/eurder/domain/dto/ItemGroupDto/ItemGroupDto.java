package com.switchfully.eurder.domain.dto.ItemGroupDto;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.domain.dto.itemdto.ItemDto;
import com.switchfully.eurder.repositories.ItemRepository;

import java.time.LocalDate;

public class ItemGroupDto {
    private String id;
    private int amount;
    private LocalDate shippingDate = LocalDate.now();
    private double price;

    public LocalDate calculateShippingDate(ItemDto itemDto) {
        if (itemDto.getAmount() - amount < 0) {
            return LocalDate.now().plusDays(7);
        }
        return LocalDate.now().plusDays(1);
    }

    public double calculatePrice(ItemDto itemDto){
        return itemDto.getPrice() * amount;
    }

    public ItemGroupDto(ItemDto itemDto, int amount) {
        this.id = itemDto.getId();
        this.amount = amount;
        this.shippingDate = calculateShippingDate(itemDto);
        this.price = calculatePrice(itemDto);
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public double getPrice() {
        return price;
    }
}
