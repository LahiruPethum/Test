package com.SpringBootTest.test.services;

import com.SpringBootTest.test.dto.ItemDTO;

public interface ItemService {


    void addItem(ItemDTO itemDTO);



    String updateItem(ItemDTO itemDTO);

    String deleteItem(int id);
}
