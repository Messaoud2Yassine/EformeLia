package spring.security.jwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.security.jwt.models.Line;

public interface LineRepository extends MongoRepository<Line, String>{
    
}
