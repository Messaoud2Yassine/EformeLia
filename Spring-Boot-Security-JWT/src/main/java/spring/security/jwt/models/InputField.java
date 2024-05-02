package spring.security.jwt.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document (collection = "inputFields")
public class InputField {
    @Id
    private String id;
    private String name;
    private String label;
    private String placeholder;
    private String type;
    private List<InputValue> inputValues;

}
