package com.example.order.dto.request;

import lombok.Builder;

@Builder
public record UpdateOrderRequestDTO(
        String name,
        String address,
        Double price
) {
}
