package com.switchfully.eurder.domain.dto.itemdto;

public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int amount;


    public ItemDto(Long id, String name, String description, double price, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
