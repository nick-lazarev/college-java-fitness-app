package Exercise;

public class Authorization {
    private boolean isAuth = false;

    private String email;
    private String password;
    private String name;
    private int age;
    private int height;  
    private int weight; 

    boolean getIsAuth() {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void login() {
        this.isAuth = true;
    }

 
    public void register() {
        System.out.println("Registration was successfully completed!");
        App.user.updateInfo(
            this.email,
            this.name,
            this.age,
            this.height,
            this.weight
        );
        this.setDefaultAuthProps();
    }


    public void logout() {
        this.isAuth = false;
        App.setDefaultSettings();
    }
}
