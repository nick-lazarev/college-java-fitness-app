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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
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

    private boolean isValidLogin(String email, String password) {
        if (App.authManager.getEmail().equals(email) && App.authManager.getPassword().equals(password)) {
            return true;  
        }
        return false; 
    }

    public void login() {
        this.isAuth = this.isValidLogin(this.email, this.password); 
        if (this.isAuth) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

 
    public void register() {
        System.out.println("Registration was successfully completed!");
        App.user.updateInfo(email, name, age, height, weight);
    }


    public void logout() {
        this.isAuth = false;
        App.user = null;  
    }
}
