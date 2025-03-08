package com.example.order.service;

import com.example.order.dto.request.AddOrderRequestDTO;
import com.example.order.dto.request.UpdateOrderRequestDTO;
import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderQueryService orderQueryService;

    public Order addOrder(AddOrderRequestDTO order) {

        Order newOrder = new Order();
        newOrder.setName(order.name());
        newOrder.setPrice(order.price());
        newOrder.setAddress(order.address());

        return orderRepository.save(newOrder);
    }

    public Order updateOrder(Long id, UpdateOrderRequestDTO order) {

        Order attachedOrder = orderQueryService.findById(id);

        attachedOrder.setName(order.name());
        attachedOrder.setPrice(order.price());
        attachedOrder.setAddress(order.address());

        return orderRepository.save(attachedOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
