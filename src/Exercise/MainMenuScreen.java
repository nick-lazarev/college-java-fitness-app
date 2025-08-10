package Exercise;

public class MainMenuScreen extends Screen {
    public void showUserInfo() {
        System.out.println("User Info:");
        System.out.println("Email: " + App.user.getEmail());
        System.out.println("Name: " + App.user.getName());
        System.out.println("Age: " + App.user.getAge());
        System.out.println("Height: " + App.user.getHeight());
        System.out.println("Weight: " + App.user.getWeight());
    }

    @Override
    public void show() {
        System.out.println("Main Menu:");
        System.out.println("1. Show User Info");
        System.out.println("2. (TODO) Log Workout");
        System.out.println("3. (TODO) Display Workouts");
        System.out.println("4. Display Total Calories");
        System.out.println("5. Exit");

        String line = sc.nextLine();
        int choice;
        try {
            choice = Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            choice = -1;
        }
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                App.redirect(AUTH_LOCATIONS_ENUM.USER_SCREEN);
                return;
            case 2:
                // log workout
                System.out.println("(TODO) Log Workout");
                break;
            case 3:
                // view workouts
                System.out.println("(TODO) Display Workouts");
                break;
            case 4:
                App.redirect(AUTH_LOCATIONS_ENUM.TOTAL_CALORIES_SCREEN);
                return;
            case 5:
                App.exit();
                return;
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
        this.show();
    }
}
