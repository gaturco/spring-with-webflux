package com.apirest.webflux.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.webflux.document.Engenheiro;
import com.apirest.webflux.repository.EngenheiroRepository;
import com.apirest.webflux.services.EngenheiroService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EngenheiroServiceImpl implements EngenheiroService {

	@Autowired
	private EngenheiroRepository repository;
	
	@Override
	public Flux<Engenheiro> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Engenheiro> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<Engenheiro> save(Engenheiro engenheiro) {
		return repository.save(engenheiro);
	}

}
