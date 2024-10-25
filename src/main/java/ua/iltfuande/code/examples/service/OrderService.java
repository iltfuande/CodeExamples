package ua.iltfuande.code.examples.service;

import org.springframework.stereotype.Service;
import ua.iltfuande.code.examples.annotation.Loggable;

@Service
@Loggable
public class OrderService {

    public String createOrder(String product) {
        return product;
    }

    public String cancelOrder(String orderId) {
        return orderId;
    }
}
