package com.madurai.fishApp.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "stock_available")
    private Double stockAvailable;

    @Column(name = "list_price")
    private Double listPrice;

    @Column(name = "discount")
    private Double discount;
}
