package Exercise;

import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.util.Date;

public class LogWorkoutScreen extends Screen {
  private Workout workout = new Workout();

  private String option = null;
	private final LinkedHashMap<String, WORKOUT_TYPES_ENUM> OPTIONS_MAP = new LinkedHashMap<String, WORKOUT_TYPES_ENUM>() {
		{
			WORKOUT_TYPES_ENUM[] menuItems = WORKOUT_TYPES_ENUM.values();
			for (int i = 0; i < menuItems.length; i++) {
				put(Integer.toString(i + 1), menuItems[i]);
			}
		}
	};
	
	private void renderOptions() {
		for (String key: this.OPTIONS_MAP.keySet()) {
			System.out.println(key + ". " + this.OPTIONS_MAP.get(key));
		}
	}

	private void enterOption() {
		try {
			System.out.println("");
			this.option = this.sc.nextLine();

			if (!this.OPTIONS_MAP.containsKey(this.option)) {
				throw new RuntimeException("Error! Please enter an option number");
			}

      this.workout.setWorkoutType(OPTIONS_MAP.get(this.option));
			
			System.out.println("");
		} catch (Exception e) {
			System.out.println(e.getMessage());
      this.renderOptions();
			this.enterOption();
			return;
		}
	}

  private void renderTitle() {
    System.err.println("");
    System.err.println("Log Workout Screen:");
    System.err.println("");
  }

  private void enterDate() {
    try {
      Date date = AppUtils.enterDate("Enter date of workout(yyyy-MM-dd): ");
      Date today = new Date();
      if (date.after(today)) {
						throw new RuntimeException("Error! Invalid date");
      }

      this.workout.setDate(date);
    } catch (Exception e) {
				System.out.println(e.getMessage());
				this.enterDate();
    }
  }

  private void enterType() {
    System.out.println("");
    System.out.println("Select type of workout: ");
    this.renderOptions();
    this.enterOption();
  }

  private void enterDistance() {
    this.workout.setDistance(AppUtils.enterPositiveDouble("Enter distance(km): "));
  }

  private void enterSets() {
    this.workout.setSets(AppUtils.enterPositiveInt("Enter sets: "));
  }

  private void enterAmount() {
    if (this.workout.getWorkoutType() == WORKOUT_TYPES_ENUM.RUNNING) {
      this.enterDistance();
    } else {
      this.enterSets();
    }
  }

  private void renderNotification() {
    System.out.println("");
    System.out.println(this.workout.toString());
    System.out.println("Workout was successfully added!");
  }


  @Override
  public void show() {
    this.renderTitle();

    this.enterDate();
    this.enterType();
    this.enterAmount();

    App.workoutManager.addWorkout(this.workout);
    this.renderNotification();

    App.redirect(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN);
  }
}
