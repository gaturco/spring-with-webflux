package com.apirest.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.apirest.webflux.document.Engenheiro;

@Repository
public interface EngenheiroRepository extends ReactiveMongoRepository<Engenheiro, String> {

}
