package Exercise;
import java.util.Scanner;

public class MainMenuScreen extends Screen {

	private String location;
	private User currentUser;

	MainMenuScreen(User user) {
			this.currentUser = user;
			this.location = "Main Menu"; 
	}

	public void showUserInfo() {
			System.out.println("User Info:");
			System.out.println("Name: " + currentUser.getName());
			System.out.println("Email: " + currentUser.getEmail());
			System.out.println("Age: " + currentUser.getAge());
			System.out.println("Height: " + currentUser.getHeight());
			System.out.println("Weight: " + currentUser.getWeight());
	}

	public void logWorkout() {
			System.out.println("Logging workout...");

	}

	public void viewWorkouts() {
			System.out.println("Viewing workouts...");
	
	}

	public void viewCalories() {
			System.out.println("Viewing total calories burned...");

	}

	@Override
	public void show() {
			System.out.println("Main Menu");
			System.out.println("1. Show User Info");
			System.out.println("2. Log Workout");
			System.out.println("3. View Workouts");
			System.out.println("4. View Calories");
			System.out.println("5. Exit");
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			handleChoice(choice);
	}

	private void handleChoice(int choice) {
			switch (choice) {
					case 1:
							showUserInfo();
							break;
					case 2:
							logWorkout();
							break;
					case 3:
							viewWorkouts();
							break;
					case 4:
							viewCalories();
							break;
					case 5:
							System.out.println("Exiting...");
							System.exit(0);
							break;
					default:
							System.out.println("Invalid choice, please try again.");
							show(); 
							break;
			}
	}
}
