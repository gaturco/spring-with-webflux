package com.apirest.webflux.services;

import com.apirest.webflux.document.Engenheiro;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EngenheiroService {
	
	Flux<Engenheiro> findAll();
	
	Mono<Engenheiro> findById(String id);
	
	Mono<Engenheiro> save(Engenheiro engenheiro);

}
