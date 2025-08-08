package Exercise;

public class User {
    private String email;
    private String name;
    private int age;
    private double height;
    private double weight;

    public User(String email, String name, int age, double height, double weight) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }


    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void setHeight(double newHeight) {
        this.height = newHeight;
    }

    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }
}
