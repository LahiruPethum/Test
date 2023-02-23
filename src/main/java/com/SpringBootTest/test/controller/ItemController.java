package com.SpringBootTest.test.controller;

import com.SpringBootTest.test.dto.ItemDTO;
import com.SpringBootTest.test.dto.request.RequestItemDTO;
import com.SpringBootTest.test.services.ItemService;
import com.SpringBootTest.test.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/inventory")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/add")
        public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestItemDTO requestItemDTO){

        String save =  itemService.addItem(requestItemDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, save),
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update")
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemDTO itemDTO){
        String update = itemService.updateItem(itemDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, update),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/remove/{id}",
    params = "sku")
    public ResponseEntity<StandardResponse> deleteItem(@PathVariable(value = "id")int id,@RequestParam(value = "sku")String sku) {

        String deleted = itemService.deleteItem(id,sku);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, deleted),
                HttpStatus.CREATED
        );
    }
}
