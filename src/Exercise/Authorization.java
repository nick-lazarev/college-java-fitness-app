package Exercise;

public class Authorization {
	private boolean isAuth = false;

	private String email;
	private String password;
	private String name;
	private int age;
	private int height;
	private int weight;

	boolean getAuthStatus() {
		return this.isAuth;
	}
	
	private void setDefaultAuthProps() {
		this.email = "" ;
		this.password = "" ;
		this.name = "";
		this.age = 0;
		this.height = 0;
		this.weight = 0;
	}
	
	void setEmail(String email) {
		if (!this.isAuth) return;

		this.email = email;
	}
	
	void setPassword(String password) {
		if (!this.isAuth) return;

		this.password = password;
	}
	
	void setName(String name) {
		if (!this.isAuth) return;

		this.name = name;
	}
	
	void setAge(int age) {
		if (!this.isAuth) return;

		this.age = age;
	}
	
	void setHeight(int height) {
		if (!this.isAuth) return;

		this.height = height;
	}
	
	void setWeight(int weight) {
		if (!this.isAuth) return;

		this.weight = weight;
	}
	
	void login() {
		//TODO: add login logic
		this.isAuth = true;
		
		this.setDefaultAuthProps();
    App.updateCurrentUser(email, this.name, this.age, this.height, this.weight);

	}

	void register() {
		System.out.println("Registration was successfully completed!");
		System.out.println("");
		
		this.setDefaultAuthProps();
		App.updateCurrentUser(email, name, age, height, weight); 
	}

	void logout() {
		//TODO: add logout logic
		this.isAuth = false;
	}
}
