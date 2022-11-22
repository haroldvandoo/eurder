package com.switchfully.eurder.domain;

import com.switchfully.eurder.exceptions.all.IdAlreadyUsedException;
import com.switchfully.eurder.repositories.ItemRepository;
import com.switchfully.eurder.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class Item {

    private String id;
    private String name;
    private String description;
    private double price;
    private int amount;
    //private ItemRepository itemRepository;



    public Item(String name, String description, double price, int amount) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    /**
    public Item(String id, String name, String description, double price, int amount, ItemRepository itemRepository) {
        this.id = validateId(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.itemRepository = itemRepository;
    }

    private String validateId(String id) {
        if(itemRepository.getItemDatabase().contains(id)) {
            throw new IdAlreadyUsedException();
        }
        return id;
    }
     */

    public String getId() {
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

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        return getId() != null ? getId().equals(item.getId()) : item.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
