package com.example.demo.repository.Item;

import com.example.demo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDao {

    @Autowired
    ItemRepository itemRepository;

    ItemDao(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void add(Item item) {
        this.itemRepository.save(item);
    }
}
