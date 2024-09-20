package org.example.repository;

import org.example.model.LoginModel;
import org.example.model.ResistrationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<ResistrationModel,String> {
}
