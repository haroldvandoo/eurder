package com.switchfully.eurder.domain;

import java.time.LocalDate;


public class ItemGroup {
    private Long itemId;
    private int amount;
    private LocalDate shippingDate = LocalDate.now();
    private double price;


    public ItemGroup(Item item, int amount) {
        this.itemId = item.getId();
        this.amount = amount;
        this.shippingDate = calculateShippingDate(item);
        this.price = calculatePrice(item);
    }

    public ItemGroup(Long itemId, int amount, LocalDate shippingDate, double price) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.price = price;
    }

    public LocalDate calculateShippingDate(Item item) {
        if (item.getAmount() - amount < 0) {
           return shippingDate.plusDays(7);
        }
        return shippingDate.plusDays(1);
    }


    public double calculatePrice(Item item){
        return item.getPrice() * amount;
    }


}
