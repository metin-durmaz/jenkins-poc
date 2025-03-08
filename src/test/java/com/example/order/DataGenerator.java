package com.example.order;

import com.example.order.dto.request.AddOrderRequestDTO;
import com.example.order.dto.request.UpdateOrderRequestDTO;
import com.example.order.entity.Order;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DataGenerator {

    private final Long LONG_FIELD = -1L;
    private final String STRING_FIELD = "stringField";
    private final Double DOUBLE_FIELD = -1D;

    public Order createOrder() {
        Order order = new Order();
        order.setId(LONG_FIELD);
        order.setName(STRING_FIELD);
        order.setPrice(DOUBLE_FIELD);
        order.setAddress(STRING_FIELD);

        return order;
    }

    public AddOrderRequestDTO createAddOrderRequestDTO() {
        return AddOrderRequestDTO.builder()
                .name(STRING_FIELD)
                .address(STRING_FIELD)
                .price(DOUBLE_FIELD)
                .build();
    }

    public UpdateOrderRequestDTO createUpdateOrderRequestDTO() {
        return UpdateOrderRequestDTO.builder()
                .name(STRING_FIELD)
                .address(STRING_FIELD)
                .price(DOUBLE_FIELD)
                .build();
    }
}
