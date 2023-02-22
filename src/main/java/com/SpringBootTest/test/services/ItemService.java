package com.SpringBootTest.test.services;

import com.SpringBootTest.test.dto.ItemDTO;
import com.SpringBootTest.test.dto.request.RequestItemDTO;

public interface ItemService {


    void addItem(RequestItemDTO requestItemDTO);



    String updateItem(ItemDTO itemDTO);

    String deleteItem(String sku);
}
