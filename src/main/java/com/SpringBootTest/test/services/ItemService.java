package com.SpringBootTest.test.services;

import com.SpringBootTest.test.dto.ItemDTO;
import com.SpringBootTest.test.dto.request.RequestItemDTO;

public interface ItemService {


    String addItem(RequestItemDTO requestItemDTO);



    String updateItem(ItemDTO itemDTO);

    String deleteItem(int id, String sku);
}
