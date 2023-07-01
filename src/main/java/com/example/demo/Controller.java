package com.example.demo;

import com.example.demo.repository.Item.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class Controller {

    @Autowired
    private ItemDao itemDao;

    Controller(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @GetMapping("/add")
    public void addItem() {
        Item item = Item.builder().name("Shivang").build();
        this.itemDao.add(item);
    }
}
