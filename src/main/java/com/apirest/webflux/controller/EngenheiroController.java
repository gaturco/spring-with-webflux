package com.apirest.webflux.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.document.Engenheiro;
import com.apirest.webflux.services.EngenheiroService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class EngenheiroController {
	
	@Autowired
	private EngenheiroService service;
	
	@GetMapping(value="/engenheiro")
	public Flux<Engenheiro> getEngeheiros() {
		return service.findAll();
	}
	
	@GetMapping(value="/engenheiro/{id}")
	public Mono<Engenheiro> getEngeheiroId(@PathVariable String id) {
		return service.findById(id);
	}
	
	@PostMapping(value="/engenheiro")
	public Mono<Engenheiro> save(@RequestBody Engenheiro eng) {
		return service.save(eng);
	}
	
	@GetMapping(value="/engenheiro/events", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Engenheiro>> getEngenheiroEvents() {
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
		Flux<Engenheiro> events = service.findAll();
		System.out.println("Passou aqui events");
		return Flux.zip(interval, events);
	}
}
