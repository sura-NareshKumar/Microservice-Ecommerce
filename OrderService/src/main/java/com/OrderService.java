package com;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Orders addOrder(Orders order) {
        Product product = productClient.getProductById(order.getProductId());
        if (product != null) {
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}