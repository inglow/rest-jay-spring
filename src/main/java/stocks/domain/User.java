package stocks.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Id
	private String id;

	String username;

	String password;

	//getter, setter, toString, Constructors

}