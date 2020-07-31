package com.gsabales.sukeebackend.repository;

import com.gsabales.sukeebackend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
