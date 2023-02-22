package com.SpringBootTest.test.dto;

import com.SpringBootTest.test.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {

    private int itemId;
    private String itemName;
    private Category category;
    private String sku;
    private String description;
    private double itemPrice;
    private double itemCount;
    private Date data;
    private String remarks;
}
