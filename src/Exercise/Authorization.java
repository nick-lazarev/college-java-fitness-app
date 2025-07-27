package Exercise;

public class Authorization {
	private boolean isAuth = false;

	private String email;
	private String password;
	private String name;
	private int age;
	private int height;
	private int weigth;

	boolean getAuthStatus() {
		return this.isAuth;
	}
	
	private void setDefaultAuthProps() {
		this.email = "" ;
		this.password = "" ;
		this.name = "";
		this.age = 0;
		this.height = 0;
		this.weigth = 0;
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
	
	void setWeigth(int weigth) {
		if (!this.isAuth) return;

		this.weigth = weigth;
	}
	
	void login() {
		//TODO: add login logic
		this.isAuth = true;
		
		this.setDefaultAuthProps();
	}

	void register() {
		System.out.println("Registration was successfully completed!");
		System.out.println("");
		
		this.setDefaultAuthProps();
	}

	void logout() {
		//TODO: add logout logic
		this.isAuth = false;
	}
}
