package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private ConcurrentHashMap<String, Item> itemDatabase;

    public ItemRepository() {
        this.itemDatabase = new ConcurrentHashMap<String, Item>();
        save((new Item("Table", "Ikea table", 600, 20)));
        save(new Item("Coffee table", "ugly coffee table", 20, 50));
        save(new Item("Dining chair", "top notch dining chair", 300, 12));
        /**
        save((new Item("1","Table", "Ikea table", 600, 20, this)));
        save(new Item("2","Coffee table", "ugly coffee table", 20, 50, this));
        save(new Item("3","Dining chair", "top notch dining chair", 300, 12, this));
         */
    }
    public void save(Item item) {
        itemDatabase.put(item.getId(), item);
    }

    public ConcurrentHashMap<String, Item> getItemDatabase() {
        return itemDatabase;
    }
}
