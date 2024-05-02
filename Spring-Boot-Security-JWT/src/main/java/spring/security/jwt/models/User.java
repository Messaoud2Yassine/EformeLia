package spring.security.jwt.models;

import java.util.HashSet;
import java.util.Set;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document (collection = "USERS")
public class User {
	
	@Id
	private String id;
	@NotBlank
	@Size(max = 50)
	private String email;
	@NotBlank
	@Size (max = 20)
	private String username;
	@NotBlank
	@Size(max = 120)
	private String password;
	  @DBRef
	private Set<Role> roles = new HashSet<>();
	public User(@NotBlank @Email @Size(max = 50) String email, @NotBlank @Size(max = 20) String username,
			@NotBlank @Size(max = 120) String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	
}
