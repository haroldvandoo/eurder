package com.switchfully.eurder.domain.dto.ItemGroupDto;

import com.switchfully.eurder.domain.dto.itemdto.ItemDto;

import java.time.LocalDate;

public class ItemGroupDto {
    private Long id;
    private int amount;
    private LocalDate shippingDate;
    private double price;

    private Long orderId;

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

    public Long getId() {
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
