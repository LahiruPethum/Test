package com.SpringBootTest.test.entity;

import com.SpringBootTest.test.entity.enums.Category;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "category",length = 25,nullable = false)
    private Category category;

    @Column(name="sku",length = 50,nullable = false)
    private String sku;

    @Column(name="description",length = 200,nullable = false)
    private String description;

    @Column(name="item_price",length = 50,nullable = false)
    private double itemPrice;

    @Column(name="item_count",length = 50,nullable = false)
    private double itemCount;

    @Column(name = "added_date",columnDefinition = "DATETIME")
    private Date data;

    @Column(name = "remarks", length = 50,nullable = false)
    private String remarks;

    public Item( String itemName, Category category, String sku, String description, double itemPrice, double itemCount, String remarks) {
        this.itemName = itemName;
        this.category = category;
        this.sku = sku;
        this.description = description;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.remarks = remarks;
    }
}
