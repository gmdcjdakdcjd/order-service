package com.polarbookshop.orderservice.order.web;

import jakarta.validation.Valid;

import com.polarbookshop.orderservice.order.domain.Order;
import com.polarbookshop.orderservice.order.domain.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {

	private final OrderService orderService;

	// 생성자를 통해 OrderService를 주입받습니다.
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	// GET /orders - 모든 주문을 조회합니다.
	@GetMapping
	public Flux<Order> getAllOrders() {
		// 모든 주문을 반환합니다. 인증 정보는 사용하지 않습니다.
		return orderService.getAllOrders();
	}

	// POST /orders - 새 주문을 제출합니다.
	@PostMapping
	public Mono<Order> submitOrder(@RequestBody @Valid OrderRequest orderRequest) {
		// 주문 요청을 받아서 새로운 주문을 제출합니다.
		return orderService.submitOrder(orderRequest.isbn(), orderRequest.quantity());
	}

}
