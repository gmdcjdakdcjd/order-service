package com.polarbookshop.orderservice.order.web;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// OrderRequest는 주문 요청을 나타내는 DTO입니다.
public record OrderRequest (

		// ISBN은 빈 문자열이 아닌 유효한 문자열이어야 합니다.
		@NotBlank(message = "The book ISBN must be defined.")
		String isbn,

		// 수량은 null이 아니어야 하며, 최소 1, 최대 5의 값을 가져야 합니다.
		@NotNull(message = "The book quantity must be defined.")
		@Min(value = 1, message = "You must order at least 1 item.")
		@Max(value = 5, message = "You cannot order more than 5 items.")
		Integer quantity

) {}
