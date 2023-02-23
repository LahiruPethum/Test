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
                new StandardResponse(200, "New item added", requestItemDTO.getItemName()),
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update")
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemDTO itemDTO){
        String update = itemService.updateItem(itemDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "item updated",update),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/remove",
    params = "id")
    public ResponseEntity<StandardResponse> deleteItem(@RequestParam(value = "id")int id) {

        String deleted = itemService.deleteItem(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "item removed",deleted),
                HttpStatus.CREATED
        );
    }
}
