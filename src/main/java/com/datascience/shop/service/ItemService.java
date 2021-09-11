package com.datascience.shop.service;

import com.datascience.shop.dto.ItemDTO;
import com.datascience.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    Item getById(Integer id);
    List<Item> getAll();
    Page<Item> getPage(String dataScienceSection,Pageable pageable);
    Item create(ItemDTO itemDTO);
    void delete(Integer id) throws ServiceException;
    void update(Integer id,ItemDTO itemDTO) throws ServiceException;
    List<Item> getByPrice (Double price);
}
