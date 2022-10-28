package com.switchfully.eurder.domain;

import com.switchfully.eurder.exceptions.all.IdAlreadyUsedException;
import com.switchfully.eurder.repositories.OrderRepository;

import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<ItemGroup> itemGroupList;

    private String phoneNumber;


    public Order(List<ItemGroup> itemGroupList, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.itemGroupList = itemGroupList;
        this.phoneNumber = phoneNumber;
    }

    public Order(String id, List<ItemGroup> itemGroupList, String phoneNumber) {
        this.id = id;
        this.itemGroupList = itemGroupList;
        this.phoneNumber = phoneNumber;
    }

    /**

    public Order(String id, List<ItemGroup> itemGroupList, String phoneNumber) {
        this.id = validateId(id);
        this.itemGroupList = itemGroupList;
        this.phoneNumber = phoneNumber;
    }

    private String validateId(String id) {
        if (orderRepository.getOrderDatabase().get(id).getId().equals(id)) {
            throw new IdAlreadyUsedException();
        }
        return id;
    }
     */

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }
}
