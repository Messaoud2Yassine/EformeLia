package spring.security.jwt.models;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "forms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Form {
    @Id
    private String id;
    private String name;
    private List<Tab> tabs;
}
