package com.apirest.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class EngenheiroRouter {

	@Bean
	public RouterFunction<ServerResponse> route(EngenheiroHandler handler) {
		return RouterFunctions
				.route(GET("/engenheiro").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/engenheiro/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/engenheiro").and(accept(MediaType.APPLICATION_JSON)), handler::save);
	}
}
