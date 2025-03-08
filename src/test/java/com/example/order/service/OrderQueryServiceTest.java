package com.example.order.service;

import com.example.order.DataGenerator;
import com.example.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderQueryServiceTest {

    @InjectMocks
    OrderQueryService orderQueryService;
    @Mock
    OrderRepository orderRepository;

    @Test
    void findById() {
        when(orderRepository.findById(-1L)).thenReturn(Optional.empty());
        var order = orderQueryService.findById(-1L);

        assertNull(order);
        verify(orderRepository, times(1)).findById(-1L);
    }

    @Test
    void findAll() {
        var order = DataGenerator.createOrder();

        when(orderRepository.findAll()).thenReturn(List.of(order));

        var orders = orderQueryService.findAll();

        assertEquals(order.getName(), orders.getFirst().getName());
        verify(orderRepository, times(1)).findAll();
    }
}
