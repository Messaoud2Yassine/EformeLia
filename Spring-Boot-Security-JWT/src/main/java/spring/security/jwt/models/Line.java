package spring.security.jwt.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document (collection = "lines")
public class Line {
    @Id
    private String id;
    private String name;
    private List<InputField> InputFields;
}
