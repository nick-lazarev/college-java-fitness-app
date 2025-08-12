package Exercise;
import java.util.HashMap;

class App {
    static Authorization authManager = new Authorization();
    static User user = new User();
    static WorkoutManager workoutManager = new WorkoutManager();

    private static Enum<?> location = authManager.getIsAuth()
            ? AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN
            : NON_AUTH_LOCATIONS_ENUM.AUTH_SCREEN;

    static void setDefaultSettings() {
        App.authManager = new Authorization();
        App.user = new User();
        App.workoutManager = new WorkoutManager();
    }

    static private Enum<?> getEnumByValue(Enum<?>[] enumValues, String value) {
        for (Enum<?> el : enumValues) {
            if (value.equalsIgnoreCase(el.toString())) {
                return el;
            }
        }

        return null;
    }

    static void goBack() {
        String[] parts = App.location.toString().split(AppContants.LOCATION_DELIMETER);

        if (parts.length < 2) {
            System.out.println("Error! There is no previous location");
            return;
        }

        
        String newLocation = parts[parts.length - 2];
        Enum<?> newLocationEnum = App.getEnumByValue(App.authManager.getIsAuth() ? AUTH_LOCATIONS_ENUM.values() : NON_AUTH_LOCATIONS_ENUM.values(), newLocation);

        if (newLocationEnum == null) {
            System.out.println("Error! There is no previous location");
            return;
        }
        
        if (App.authManager.getIsAuth()) {
            App.redirect((AUTH_LOCATIONS_ENUM) newLocationEnum);
        } else {
            App.redirect((NON_AUTH_LOCATIONS_ENUM) newLocationEnum);
        }
        
    }

    static void redirect(AUTH_LOCATIONS_ENUM value) {
        App.location = value;
        App.showScreen();
    }
    
    static void redirect(NON_AUTH_LOCATIONS_ENUM value) {
        App.location = value;
        App.showScreen();
    }

    static void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    static private final HashMap<NON_AUTH_LOCATIONS_ENUM, Screen> NON_AUTH_SCREENS =
            new HashMap<NON_AUTH_LOCATIONS_ENUM, Screen>() {{
                put(NON_AUTH_LOCATIONS_ENUM.AUTH_SCREEN, new AuthScreen());
                put(NON_AUTH_LOCATIONS_ENUM.LOGIN_SCREEN, new LoginScreen());
                put(NON_AUTH_LOCATIONS_ENUM.REGISTRATION_SCREEN, new RegistrationScreen());
            }};

    static private final HashMap<AUTH_LOCATIONS_ENUM, Screen> AUTH_SCREENS =
            new HashMap<AUTH_LOCATIONS_ENUM, Screen>() {{
                put(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN, new MainMenuScreen());
                put(AUTH_LOCATIONS_ENUM.USER_SCREEN, new UserScreen());
                put(AUTH_LOCATIONS_ENUM.LOG_WORKOUT_SCREEN, new LogWorkoutScreen());
                put(AUTH_LOCATIONS_ENUM.WORKOUT_LIST_SCREEN, new WorkoutListScreen());
                put(AUTH_LOCATIONS_ENUM.TOTAL_CALORIES_SCREEN, new TotalCaloriesScreen()); 
            }};

    static void showScreen() {
        Screen currentScreen;

        if (App.authManager.getIsAuth()) {
            if (!(App.location instanceof AUTH_LOCATIONS_ENUM)) {
                App.location = AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN;
            }
            currentScreen = AUTH_SCREENS.get((AUTH_LOCATIONS_ENUM) App.location);
        } else {
            if (!(App.location instanceof NON_AUTH_LOCATIONS_ENUM)) {
                App.location = NON_AUTH_LOCATIONS_ENUM.AUTH_SCREEN;
            }
            currentScreen = NON_AUTH_SCREENS.get((NON_AUTH_LOCATIONS_ENUM) App.location);
        }

        currentScreen.show();
    }
}