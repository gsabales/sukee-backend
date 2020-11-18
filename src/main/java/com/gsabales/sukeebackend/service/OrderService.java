package com.gsabales.sukeebackend.service;

import com.gsabales.sukeebackend.model.Cart;
import com.gsabales.sukeebackend.model.Item;
import com.gsabales.sukeebackend.model.Orders;
import com.gsabales.sukeebackend.model.User;
import com.gsabales.sukeebackend.repository.CartRepository;
import com.gsabales.sukeebackend.repository.OrderRepository;
import com.gsabales.sukeebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public Orders createOrder(int customerId, Item purchasedItem) {
        Optional<User> customer =  userRepository.findById(customerId);
        Optional<Cart> customerCart = cartRepository.findById(customerId);

        // Create new order
        Orders orders = new Orders();
        orders.setOrderDate(LocalDateTime.now());
        orders.setOrderStatus("PENDING"); // Convert to enum

        // If customer exists, add customer to order
        customer.ifPresent(orders::setCustomer);

        // If customer cart exists, add purchased item to cart
//        customerCart.ifPresent(cart -> cart.getItems().add(purchasedItem));

        return orderRepository.save(orders);
    }
}
