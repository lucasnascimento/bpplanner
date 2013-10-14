package br.com.lnprojetos.bpplanner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjetoRepository extends MongoRepository<Projeto, String> {
}
