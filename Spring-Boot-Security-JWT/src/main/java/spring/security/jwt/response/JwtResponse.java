package spring.security.jwt.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	private String token ;
	private String username;
	private String email;
	private String id;
	private List<String>roles;
	private String type = "Bearer";
	public JwtResponse(String token, String id, String email, String username, List<String> roles) {
		super();
		this.token = token;
		this.username = username;
		this.email = email;
		this.id = id;
		this.roles = roles;

	}

}
