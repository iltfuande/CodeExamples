package ua.iltfuande.code.examples.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.iltfuande.code.examples.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String createOrder(@RequestParam String product) {
        return "Order created: " + orderService.createOrder(product);
    }

    @PutMapping
    public String updateUser(@RequestParam String product) {
        return "Order canceled: " + orderService.cancelOrder(product);
    }
}