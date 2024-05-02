package spring.security.jwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.security.jwt.models.Tab;

public interface TabRepository extends MongoRepository<Tab, String>{
    
}
