package spring.security.jwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.security.jwt.models.Form;

public interface FormRepository extends MongoRepository<Form, String>{
    
}
