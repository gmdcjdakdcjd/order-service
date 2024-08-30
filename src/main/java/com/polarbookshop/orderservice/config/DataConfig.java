package com.polarbookshop.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import reactor.core.publisher.Mono;

@Configuration
@EnableR2dbcAuditing
public class DataConfig {

	@Bean
	ReactiveAuditorAware<String> auditorAware() {
		// 기본 사용자 이름 "system"으로 설정
		return () -> Mono.just("system");
	}

}
