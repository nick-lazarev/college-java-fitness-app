package Exercise;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class WorkoutScreen extends Screen {
    private String option;
    private Date minDate = null;
    private Date maxDate = null;
    
    protected void setDefaultSettings() {
        this.option = "";
        this.minDate = null;
        this.maxDate = null;
    }

	private final LinkedHashMap<String, WORKOUT_SCREEN_OPTIONS_ENUM> OPTIONS_MAP = new LinkedHashMap<String, WORKOUT_SCREEN_OPTIONS_ENUM>() {
		{
			WORKOUT_SCREEN_OPTIONS_ENUM[] menuItems = WORKOUT_SCREEN_OPTIONS_ENUM.values();
			for (int i = 0; i < menuItems.length; i++) {
				if (menuItems[i] == WORKOUT_SCREEN_OPTIONS_ENUM.BACK) {
					put("0", menuItems[i]);
					break;
				}

				put(Integer.toString(i + 1), menuItems[i]);
			}
		}
	};
	
	protected void renderOptions() {
		for (String key: this.OPTIONS_MAP.keySet()) {
			if (this.OPTIONS_MAP.get(key) == WORKOUT_SCREEN_OPTIONS_ENUM.BACK) {
				System.out.println("");
			}
			System.out.println(key + ". " + this.OPTIONS_MAP.get(key));
		}
	}
	
	protected void enterOption() {
		try {
			System.out.println("");
			this.option = sc.nextLine();

			if (!this.OPTIONS_MAP.containsKey(this.option)) {
				throw new RuntimeException("Error! Please enter an option number");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.enterOption();
			return;
		}
	}

    private void enterMinDate() {
        this.minDate = AppUtils.enterDate("Enter min date(yyyy-MM-dd): ");
    }

    private void enterMaxDate() {
        try {
            Date date = null;
            date = AppUtils.enterDate("Enter max date(yyyy-MM-dd): ");

            if (date.before(this.minDate)) {
				throw new RuntimeException("Error! Max date should be later than min date");
            }
            this.maxDate = date;
			System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.enterMaxDate();
        }

    }

    private WORKOUT_SCREEN_OPTIONS_ENUM getOptionValue() {
        return this.OPTIONS_MAP.get(this.option);
    }
	
	protected void handleOption() {
		WORKOUT_SCREEN_OPTIONS_ENUM optionValue = this.getOptionValue();
		
		if (optionValue == WORKOUT_SCREEN_OPTIONS_ENUM.BACK) {
            App.goBack();
            return;
		} else if (optionValue == WORKOUT_SCREEN_OPTIONS_ENUM.ENTER_DATES) {
            this.enterMinDate();
            this.enterMaxDate();
		}
	}

    protected void renderTotalCalories() {
        List<Workout> workoutList = App.workoutManager.getWorkoutList(this.minDate, this.maxDate);
        double totalCalories = App.workoutManager.getTotalCalories(this.minDate, this.maxDate);
		WORKOUT_SCREEN_OPTIONS_ENUM optionValue = this.getOptionValue();

        if (optionValue == WORKOUT_SCREEN_OPTIONS_ENUM.ENTER_DATES) {
            System.out.println("Min date: " + this.minDate);
            System.out.println("Max date: " + this.maxDate);
        } else {
            System.out.println("Data for all time");
        }

        System.out.println("Workouts count: " + workoutList.size());
        System.out.println("Total calories: " + totalCalories);
    }

    protected void renderWorkoutList() {
        List<Workout> workoutList = App.workoutManager.getWorkoutList(this.minDate, this.maxDate);
		WORKOUT_SCREEN_OPTIONS_ENUM optionValue = this.getOptionValue();

        if (optionValue == WORKOUT_SCREEN_OPTIONS_ENUM.ENTER_DATES) {
            System.out.println("Min date: " + this.minDate);
            System.out.println("Max date: " + this.maxDate);
        } else {
            System.out.println("Data for all time");
        }

        System.out.println("Workouts count: " + workoutList.size());

        for (Workout el : workoutList) {
            System.out.println("- " + el);
        }
    }
}
