package Exercise;

public class MainMenuScreen extends Screen {
    @Override
    public void show() {
        System.out.println();
        System.out.println("Main Menu:");
        System.out.println("1. Show User Info");
        System.out.println("2. Log Workout");
        System.out.println("3. Display Workouts");
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
                App.redirect(AUTH_LOCATIONS_ENUM.LOG_WORKOUT_SCREEN);
                return;
            case 3:
                App.redirect(AUTH_LOCATIONS_ENUM.WORKOUT_LIST_SCREEN);
                return;
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
