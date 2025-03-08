package com.example.order.service;

import com.example.order.DataGenerator;
import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    OrderService orderService;
    @Mock
    OrderRepository orderRepository;
    @Mock
    OrderQueryService orderQueryService;

    @Test
    void addOrder() {
        var addOrderRequestDTO = DataGenerator.createAddOrderRequestDTO();
        var expectedOrder = DataGenerator.createOrder();

        when(orderRepository.save(any(Order.class))).thenReturn(expectedOrder);

        var actualOrder = orderService.addOrder(addOrderRequestDTO);

        assertEquals(expectedOrder, actualOrder);
        verify(orderRepository, times(1)).save(any(Order.class));
    }
}
