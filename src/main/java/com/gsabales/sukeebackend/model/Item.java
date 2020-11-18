package com.gsabales.sukeebackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;
    private int stock;

    @ManyToOne
    @JoinColumn(
            name="cart_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name="fk_item_cart_id"),
            nullable = false)
    @JsonBackReference
    @ToString.Exclude
    private Cart cart;

    @ManyToMany(mappedBy = "itemsOrdered")
    private List<Orders> orders;
}
