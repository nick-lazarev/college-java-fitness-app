package Exercise;

public class UserInfoScreen extends Screen {
    private User user;  
    private String location;

    
    public UserInfoScreen(User user) {
        this.user = user;
    }

   @Override
    public void show() {
        System.out.println("User Info Screen");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Height: " + user.getHeight());
        System.out.println("Weight: " + user.getWeight());
        

        System.out.println("1. Edit User Info");
        System.out.println("2. Go Back");
    }


    public void goBack() {
        System.out.println("Going back to previous screen...");
    }
}
