package Exercise;
 
public class UserScreen extends Screen {  
    @Override
    public void show() {
        if (App.user == null) {
            System.out.println("App.user Info Screen: (no App.user)");
            System.out.println("Press Enter to go back...");
            sc.nextLine();
            App.redirect(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN);
            return;
        }

        System.out.println("App.user Info Screen:");
        System.out.println("Email: " + App.user.getEmail());
        System.out.println("Name: " + App.user.getName());
        System.out.println("Age: " + App.user.getAge());
        System.out.println("Height: " + App.user.getHeight());
        System.out.println("Weight: " + App.user.getWeight());
        System.out.println();
        System.out.println("1. Edit User Info");
        System.out.println("2. Go Back");

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
                editUserInfo();
                break;
            case 2:
                goBack();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                show();
                break;
        }
    }

    private void editUserInfo() {
        System.out.println("Editing App.user Info (press Enter to keep current value)");
        System.out.print("Name [" + App.user.getName() + "]: ");
        String nameIn = sc.nextLine().trim();
        String newName = nameIn.isEmpty() ? App.user.getName() : nameIn;

        Integer newAge = App.user.getAge();
        System.out.print("Age [" + App.user.getAge() + "]: ");
        String ageIn = sc.nextLine().trim();
        if (!ageIn.isEmpty()) {
            try {
                int parsed = Integer.parseInt(ageIn);
                if (parsed < 0) throw new NumberFormatException();
                newAge = parsed;
            } catch (NumberFormatException e) {
                System.out.println("Invalid age, keep current.");
            }
        }

        int newHeight = App.user.getHeight();
        System.out.print("Height (cm) [" + App.user.getHeight() + "]: ");
        String heightIn = sc.nextLine().trim();
        if (!heightIn.isEmpty()) {
            try {
                newHeight = Integer.parseInt(heightIn);
            } catch (NumberFormatException e) {
                System.out.println("Invalid height, keep current.");
            }
        }

   
        int newWeight = App.user.getWeight();
        System.out.print("Weight (kg) [" + App.user.getWeight() + "]: ");
        String weightIn = sc.nextLine().trim();
        if (!weightIn.isEmpty()) {
            try {
                newWeight = Integer.parseInt(weightIn);
            } catch (NumberFormatException e) {
                System.out.println("Invalid weight, keep current.");
            }
        }

        App.user.updateInfo(
            App.user.getEmail(),  
            newName,
            newAge,
            newHeight,
            newWeight
        );

        System.out.println("User info updated successfully!");
        System.out.println();
        show();  
    }

    private void goBack() {
        App.redirect(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN);
    }
}
