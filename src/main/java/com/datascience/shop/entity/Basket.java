//package com.datascience.shop.entity;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name="baskets")
//public class Basket extends BaseEntity {
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="user_id")
//
//    private User client;
//     //  @OneToMany(mappedBy="basket",fetch = FetchType.EAGER) //
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="item_id")
//    private List<Item> items;// = new ArrayList<>();
//
//    public Basket() {
//    }
//
//    public Basket(Integer id, User client, List<Item> items) {
//        super(id);
//        this.client = client;
//        this.items = items;
//    }
//
//    public Basket(User client, List<Item> items) {
//        this.client = client;
//        this.items = items;
//    }
//
//    public User getClient() {
//        return client;
//    }
//
//    public void setClient(User client) {
//        this.client = client;
//    }
//
//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
//
//    @Override
//    public String toString() {
//        return "Basket{" +
//                "id" + super.getId() +
//                ", client=" + client.toString() + "\n" +
//                ", itemsInBasket=" + items.toString() +
//                '}' + "\n";
//    }
//}