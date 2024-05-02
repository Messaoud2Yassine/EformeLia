package spring.security.jwt.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document (collection = "inputValues")
public class InputValue {
    @Id
    private InputValueId inputValueId;
    private String inputValue;
}
