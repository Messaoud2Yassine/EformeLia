package spring.security.jwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.security.jwt.models.InputValue;
import spring.security.jwt.models.InputValueId;

public interface InputValueRepository extends MongoRepository<InputValue, InputValueId>{
    InputValue findByInputValueIdIdInputValueAndInputValueIdIdUser(String idInputField, String idUser);

}
