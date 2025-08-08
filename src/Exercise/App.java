package Exercise;
import java.util.HashMap;

class App {
    static Authorization authManager = new Authorization();

    private static Enum<?> location = authManager.getAuthStatus()
            ? AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN
            : NON_AUTH_LOCATIONS_ENUM.AUTH_SCREEN;

    static User user = new User();

    static void goBack() {
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

    static protected HashMap<NON_AUTH_LOCATIONS_ENUM, Screen> NON_AUTH_SCREENS =
            new HashMap<NON_AUTH_LOCATIONS_ENUM, Screen>() {{
                put(NON_AUTH_LOCATIONS_ENUM.AUTH_SCREEN, new AuthScreen());
                put(NON_AUTH_LOCATIONS_ENUM.LOGIN_SCREEN, new LoginScreen());
                put(NON_AUTH_LOCATIONS_ENUM.REGISTRATION_SCREEN, new RegistrationScreen());
            }};

    static protected HashMap<AUTH_LOCATIONS_ENUM, Screen> AUTH_SCREENS =
            new HashMap<AUTH_LOCATIONS_ENUM, Screen>() {{
                put(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN, new MainMenuScreen());
                put(AUTH_LOCATIONS_ENUM.USER_SCREEN, new UserScreen()); 
            }};

    static void showScreen() {
        Screen currentScreen;

        if (App.authManager.getAuthStatus()) {
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