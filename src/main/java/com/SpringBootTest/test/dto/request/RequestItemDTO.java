package com.SpringBootTest.test.dto.request;

import com.SpringBootTest.test.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class RequestItemDTO {

    @NotBlank(message = "The name field is required.")
    private String itemName;
    @NotBlank(message = "The category field is required.")
    private Category category;
    @NotBlank(message = "Email is mandatory")
    private String sku;
    @NotBlank(message = "The description field is required.")
    private String description;
    @NotBlank(message = "The price field is required.")
    private double itemPrice;
    @NotBlank(message = "The count field is required.")
    private double itemCount;
    @NotBlank(message = "The remark field is required.")
    private String remarks;
}
