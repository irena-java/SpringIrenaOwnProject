package com.datascience.shop.repository;

import com.datascience.shop.entity.Item;
import com.datascience.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{

    @Query(value="select i from Item i")
    List<Item> allItem();


    List<Item> findAllByPriceIs(Double price);
    List<Item> findAllByUsers(User user);

    @Query("select u from User u where size(u.items)>0")
    List<User> basketInUser();

}
