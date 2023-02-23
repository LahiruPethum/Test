package com.SpringBootTest.test.services.serviceIMPL;

import com.SpringBootTest.test.dto.ItemDTO;
import com.SpringBootTest.test.dto.request.RequestItemDTO;
import com.SpringBootTest.test.entity.Item;
import com.SpringBootTest.test.exception.NotFoundExeption;
import com.SpringBootTest.test.repo.ItemRepo;
import com.SpringBootTest.test.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;


    @Override
    public String addItem(RequestItemDTO requestItemDTO) {
        Item item = new Item(
//                itemDTO.getItemId(),
                requestItemDTO.getItemName(),
                requestItemDTO.getCategory(),
                requestItemDTO.getSku(),
                requestItemDTO.getDescription(),
                requestItemDTO.getItemPrice(),
                requestItemDTO.getItemCount(),
//                itemDTO.getData(),
                requestItemDTO.getRemarks()

        );

        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return "New item added";
        } else {
            System.out.println("already in table");
            throw new NotFoundExeption("Validation Exception");
        }
    }


    @Override
    public String updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemId())) {
            Item item = itemRepo.getById(itemDTO.getItemId());

            item.setItemName(itemDTO.getItemName());
            item.setItemCount(itemDTO.getItemCount());
            item.setItemPrice(itemDTO.getItemPrice());
            item.setCategory(itemDTO.getCategory());
            item.setData(itemDTO.getData());
            item.setSku(itemDTO.getSku());



            itemRepo.save(item);
            return "updated";

        }else {
            throw new NotFoundExeption("Validation Exception");

        }

    }

    @Override
    public String deleteItem(int id) {

        if (itemRepo.existsById(id)){
            itemRepo.deleteById(id);
            return "item removed";
        }else {
            throw new NotFoundExeption("Validation Exception");
        }
    }
}
