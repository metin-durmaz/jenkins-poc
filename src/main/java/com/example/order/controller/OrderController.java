package com.example.order.controller;

import com.example.order.dto.request.AddOrderRequestDTO;
import com.example.order.dto.request.UpdateOrderRequestDTO;
import com.example.order.entity.Order;
import com.example.order.service.OrderQueryService;
import com.example.order.service.OrderService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/order")
@RestController
public class OrderController {

    private final OrderQueryService orderQueryService;
    private final OrderService orderService;

    @GetMapping("/findById")
    public Order findById(@RequestParam("id") @Parameter(example = "1") Long id) {
        return orderQueryService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Order> findAll() {
        return orderQueryService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addOrder")
    public Order addOrder(@RequestBody @Schema(type = "object",
            example = OrderSwaggerExamples.ADD_ORDER) @Valid AddOrderRequestDTO order) {

        return orderService.addOrder(order);
    }

    @PutMapping("updateOrder/{id}")
    public Order updateOrder(@PathVariable("id") @Parameter(example = "1") Long id,
                             @RequestBody @Schema(type = "object", example = OrderSwaggerExamples.UPDATE_ORDER)
                             @Valid UpdateOrderRequestDTO order) {

        return orderService.updateOrder(id, order);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") @Parameter(example = "2") Long id) {
        orderService.deleteOrder(id);
    }
}
