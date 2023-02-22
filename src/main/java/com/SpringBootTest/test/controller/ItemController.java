package com.SpringBootTest.test.controller;

import com.SpringBootTest.test.dto.ItemDTO;
import com.SpringBootTest.test.dto.request.RequestItemDTO;
import com.SpringBootTest.test.services.ItemService;
import com.SpringBootTest.test.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/add")
        public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestItemDTO requestItemDTO){

            itemService.addItem(requestItemDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "New item added"),
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update")
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemDTO itemDTO){
        String update = itemService.updateItem(itemDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "item updated"),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/remove",
    params = "sku")
    public ResponseEntity<StandardResponse> deleteItem(@RequestParam(value = "sku")String sku) {

        String deleted = itemService.deleteItem(sku);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "item removed"),
                HttpStatus.CREATED
        );
    }
}
