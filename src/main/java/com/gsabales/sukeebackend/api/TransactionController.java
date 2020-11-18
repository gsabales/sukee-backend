package com.gsabales.sukeebackend.api;

import com.gsabales.sukeebackend.model.Item;
import com.gsabales.sukeebackend.model.Orders;
import com.gsabales.sukeebackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final OrderService orderService;

    @PostMapping("{id}/order")
    public ResponseEntity<Orders> createOrder(@PathVariable int id, @RequestBody Item item) {

        Orders customerCart = orderService.createOrder(id, item);

        if (customerCart != null) {
            return ResponseEntity.ok().body(customerCart);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
