package com.apirest.webflux;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apirest.webflux.document.Engenheiro;
import com.apirest.webflux.repository.EngenheiroRepository;

import reactor.core.publisher.Flux;

//@Component
//public class DummyData implements CommandLineRunner {
//
//	private final EngenheiroRepository repository;
//	
//	DummyData(EngenheiroRepository repository) {
//		this.repository = repository;
//	}
//	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		repository.deleteAll()
//			.thenMany(Flux.just(
//					new Engenheiro(UUID.randomUUID().toString(),"Allan"),
//					new Engenheiro(UUID.randomUUID().toString(),"Godoi"),
//					new Engenheiro(UUID.randomUUID().toString(),"Turco"),
//					new Engenheiro(UUID.randomUUID().toString(),"Cezar"),
//					new Engenheiro(UUID.randomUUID().toString(),"Alisson"))
//					.flatMap(repository::save))
//			.subscribe(System.out::println);
//					
//	}
//}
