package spring.security.jwt.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputValueId implements Serializable {
    private String idInputValue;
    private String idUser;
}
