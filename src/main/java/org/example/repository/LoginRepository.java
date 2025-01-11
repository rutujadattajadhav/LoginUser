package org.example.repository;

import org.example.model.ResistrationModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends ReactiveCrudRepository<ResistrationModel,String> {
}
