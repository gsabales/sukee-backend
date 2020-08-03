package com.gsabales.sukeebackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private Long price;
    private int quantity;

    @ManyToOne
    @JoinColumn(
            name="cart_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name="fk_item_cart_id"),
            nullable = false)
    @JsonBackReference
    @ToString.Exclude
    public Cart cart;
}
