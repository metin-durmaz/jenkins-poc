package com.example.order.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record AddOrderRequestDTO(

        @NotNull String name,
        @NotNull String address,
        @NotNull Double price
) {
}
