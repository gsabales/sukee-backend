package com.gsabales.sukeebackend.api;

import com.gsabales.sukeebackend.model.Item;
import com.gsabales.sukeebackend.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        Optional<Item> item = itemRepository.findById(id);

        return item.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemRepository.findAll();

        if (!items.isEmpty()) {
            return ResponseEntity.ok().body(items);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
