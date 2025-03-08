package com.example.order.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OrderSwaggerExamples {

    public static final String ADD_ORDER = """
            {
                "name": "Pizza",
                "address": "Pursaklar",
                "price": 350
            }
            """;

    public static final String UPDATE_ORDER = """
            {
                "name": "Makarna",
                "address": "Çankaya",
                "price": 250
            }
            """;
}
