package com.polarbookshop.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.domain.ReactiveAuditorAware;
import reactor.core.publisher.Mono;

@Configuration
@EnableR2dbcAuditing
public class DataConfig {

	@Bean
	ReactiveAuditorAware<String> auditorAware() {
		// 기본적으로 auditor는 'system' 또는 'unknown'으로 설정될 수 있습니다.
		return () -> Mono.just("system"); // 인증 없이 기본 값 사용
	}

}
