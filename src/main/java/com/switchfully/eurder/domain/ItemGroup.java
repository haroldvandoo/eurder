package com.switchfully.eurder.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "item_group")
public class ItemGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemgroup_seq")
    @SequenceGenerator(name = "itemgroup_seq", sequenceName = "itemgroup_seq", allocationSize = 1)
    private Long id;

    @Column(name = "fk_item_id")
    private Long itemId;
    @Column(name = "amount")
    private int amount;
    @Column(name = "shipping_date")
    private LocalDate shippingDate;
    @Column(name = "price")
    private double price;
    //@OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_order_id")
    private Long orderId;



    public ItemGroup() {
    }

    public ItemGroup(Long itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
