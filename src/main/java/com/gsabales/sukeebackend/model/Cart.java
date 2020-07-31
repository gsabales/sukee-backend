package com.gsabales.sukeebackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(
            name="user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name="fk_cart_user_id"))
    private User user;

//    @OneToMany(mappedBy = "cart")
//    private Set<Item> item;
}
