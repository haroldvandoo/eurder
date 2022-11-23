package com.switchfully.eurder.domain;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int amount;


    public Item() {
    }

    public Item(String name, String description, double price, int amount) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void substractAmount(int orderedAmount) {
        this.amount -= orderedAmount;
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
