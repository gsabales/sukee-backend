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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime orderDate;
    private String orderStatus;

    @ManyToMany
    @JoinTable(
            name = "order_details",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(name = "fk_order_item_order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"),
            inverseForeignKey = @ForeignKey(name = "fk_order_item_item_id")
    )
    private List<Item> itemsOrdered;

    @ManyToOne
    @JoinColumn(
            name="customer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name="fk_order_user_customer_id"),
            nullable = false)
    @JsonBackReference
    @ToString.Exclude
    private User customer;
}
