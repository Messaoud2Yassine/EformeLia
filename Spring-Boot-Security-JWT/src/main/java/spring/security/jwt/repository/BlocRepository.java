package spring.security.jwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.security.jwt.models.Bloc;

public interface BlocRepository extends MongoRepository<Bloc, String>{
    
}
