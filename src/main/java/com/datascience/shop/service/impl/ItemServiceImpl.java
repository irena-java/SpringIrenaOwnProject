package com.datascience.shop.service.impl;

import com.datascience.shop.dto.ItemDTO;
import com.datascience.shop.entity.Item;
import com.datascience.shop.repository.ItemRepository;
import com.datascience.shop.service.ItemService;
import com.datascience.shop.service.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public Item getById(Integer id) {
        Item item=itemRepository.findById(id)
                .orElseThrow(()->{
                    throw new RuntimeException("не удалось найти позицию с Id "+id);
                });
        return item;
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Page<Item> getPage(String dataScienceSection,Pageable pageable) {
        return itemRepository.findAllByDataScienceSectionContaining (dataScienceSection,pageable);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Item create(ItemDTO itemDTO) {
        if(!Objects.isNull(itemDTO.getId())){
            throw new IllegalArgumentException("уже существует такая позиция");
        }
        Item item = new Item();
        BeanUtils.copyProperties(itemDTO,item);
        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ServiceException {
        if(!itemRepository.existsById(id)){
            throw new ServiceException("такой позиции нет");
        }
            itemRepository.deleteById(id);
    }

    @Override
    public void update(Integer id,ItemDTO itemDTO) throws ServiceException {
        if(!itemRepository.existsById(id)){
            throw new ServiceException("такой позиции нет");
        }
        Item item = new Item();
        BeanUtils.copyProperties(itemDTO,item);
        item.setId(id);
        itemRepository.save(item);
    }

    @Override
    public List<Item> getByPrice(Double price) {
        List<Item> items=itemRepository.findAllByPriceIs(price);
        return items;
    }
}
