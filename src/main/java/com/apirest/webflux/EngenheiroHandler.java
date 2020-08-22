package com.apirest.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.apirest.webflux.document.Engenheiro;
import com.apirest.webflux.services.EngenheiroService;

import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

//@Component
public class EngenheiroHandler {
	
	@Autowired
	private EngenheiroService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Engenheiro.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id), Engenheiro.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<Engenheiro> engenheiro = request.bodyToMono(Engenheiro.class);
		
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(engenheiro.flatMap(service::save), Engenheiro.class));
	}

}
