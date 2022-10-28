package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.domain.ItemGroup;
import com.switchfully.eurder.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {

    private ConcurrentHashMap<String, Order> orderDatabase;

    public OrderRepository() {
        this.orderDatabase = new ConcurrentHashMap<String, Order>();
        Item item1 = new Item("Table", "Ikea table", 600, 20);
        Item item2 = new Item("Coffee table", "ugly coffee table", 20, 50);
        Item item3 = new Item("Dining chair", "top notch dining chair", 300, 12);

        ItemGroup itemGroup1 = new ItemGroup(item1, 5);
        ItemGroup itemGroup2 = new ItemGroup(item2, 3);
        ItemGroup itemGroup3 = new ItemGroup(item1, 10);
        ItemGroup itemGroup4 = new ItemGroup(item3, 6);
        List<ItemGroup> itemGroupList1 = Arrays.asList(itemGroup1, itemGroup2);
        List<ItemGroup> itemGroupList2 = Arrays.asList(itemGroup3, itemGroup4);

        save(new Order( itemGroupList1, "02457568764"));
        save(new Order( itemGroupList2, "0245785123"));
    }

    public void save(Order order) {
        orderDatabase.put(order.getId(), order);
    }

    public ConcurrentHashMap<String, Order> getOrderDatabase() {
        return orderDatabase;
    }
}
