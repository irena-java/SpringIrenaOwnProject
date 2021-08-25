//package com.datascience.shop.dao;
//
//import com.datascience.shop.entity.Basket;
//import com.datascience.shop.entity.User;
//
//import java.sql.Connection;
//import java.util.List;
//
//public interface BasketDao {
//    Basket insertOrUpdate(Basket basket) throws DaoException;
//
//    void deleteBasket(Basket basket, Connection connection) throws DaoException;
//
//    void deleteFromBasketByItemId(Integer userId, Integer itemId) throws DaoException;
//
//    Basket findById(Integer id) throws DaoException;
//
//    Basket findByUser(User user) throws DaoException;
//
//    List<Basket> findAll() throws DaoException;
//}
