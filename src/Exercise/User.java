package Exercise;

public class User {
    private String email;
    private String name;
    private int age;
    private int height;
    private int weight;

    public void updateInfo(String email, String name, int age, int height, int weight) {
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

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }
}
