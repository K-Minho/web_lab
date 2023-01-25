package model;

public class UserRepository {
	public User insert() {
		return newUser(1);
	}
	
	public User findById(int id) {
		return newUser(id);
	}
	
	// dummy
	private User newUser(int id) {
		User user = new User();
		user.setId(id);
		user.setUsername("user"+ id );
		user.setPassword("password" + id);
		user.setEmail("user"+id+"@email.com");
		return user;
	}
}
