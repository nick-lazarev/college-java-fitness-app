package Exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class TotalCaloriesScreen extends Screen {
    private String option;
    private Date minDate = null;
    private Date maxDate = null;
    private SimpleDateFormat ISO = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    
    private void setDefaultSettings() {
        this.option = "";
        this.minDate = null;
        this.maxDate = null;
    }

	private final LinkedHashMap<String, TOTAL_CALORIES_SCREEN_OPTIONS_ENUM> OPTIONS_MAP = new LinkedHashMap<String, TOTAL_CALORIES_SCREEN_OPTIONS_ENUM>() {
		{
			TOTAL_CALORIES_SCREEN_OPTIONS_ENUM[] menuItems = TOTAL_CALORIES_SCREEN_OPTIONS_ENUM.values();
			for (int i = 0; i < menuItems.length; i++) {
				if (menuItems[i] == TOTAL_CALORIES_SCREEN_OPTIONS_ENUM.BACK) {
					put("0", menuItems[i]);
					break;
				}

				put(Integer.toString(i + 1), menuItems[i]);
			}
		}
	};
	
	private void renderOptions() {
		for (String key: this.OPTIONS_MAP.keySet()) {
			if (this.OPTIONS_MAP.get(key) == TOTAL_CALORIES_SCREEN_OPTIONS_ENUM.BACK) {
				System.out.println("");
			}
			System.out.println(key + ". " + this.OPTIONS_MAP.get(key));
		}
	}
	
	private void enterOption() {
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

    private Date enterDate() {
        Date date = null;
        try {
            String value = this.sc.nextLine();
            date = ISO.parse(value);
        } catch (ParseException e) {
            System.out.println("Date must be yyyy-MM-dd");
            date = this.enterDate();
        }

        return date;
    }

    private void enterMinDate() {
        System.out.println("");
        System.out.print("Enter min date: ");
        this.minDate = this.enterDate();
    }

    private void enterMaxDate() {
        try {
            Date date = null;
            System.out.println("");
            System.out.print("Enter max date: ");
            date = this.enterDate();

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

    private TOTAL_CALORIES_SCREEN_OPTIONS_ENUM getOptionValue() {
        return this.OPTIONS_MAP.get(this.option);
    }
	
	private void handleOption() {
		TOTAL_CALORIES_SCREEN_OPTIONS_ENUM optionValue = this.getOptionValue();
		
		if (optionValue == TOTAL_CALORIES_SCREEN_OPTIONS_ENUM.BACK) {
            //TODO: use app go back
			App.redirect(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN);
            return;
		} else if (optionValue == TOTAL_CALORIES_SCREEN_OPTIONS_ENUM.ENTER_DATES) {
            this.enterMinDate();
            this.enterMaxDate();
		}
	}

    private void renderResult() {
        List<Workout> workoutList = App.workoutManager.getWorkoutList(this.minDate, this.maxDate);
        double totalCalories = App.workoutManager.getTotalCalories(this.minDate, this.maxDate);
		TOTAL_CALORIES_SCREEN_OPTIONS_ENUM optionValue = this.getOptionValue();

        if (optionValue == TOTAL_CALORIES_SCREEN_OPTIONS_ENUM.ENTER_DATES) {
            System.out.println("Min date: " + this.minDate);
            System.out.println("Max date: " + this.maxDate);
        } else {
            System.out.println("Data for all time");
        }

        System.out.println("Workouts count: " + workoutList.size());
        System.out.println("Total calories: " + totalCalories);
    }

    @Override
    public void show() {
        System.out.println("");
        System.out.println("TotalCaloriesScreen: ");
        System.out.println("");

        this.renderOptions();
        this.enterOption();
        this.handleOption();
        this.renderResult();

        this.setDefaultSettings();
        this.show();
    }
}
