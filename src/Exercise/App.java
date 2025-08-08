package Exercise;
import java.util.HashMap;

class App {
	static User currentUser;
	static Authorization AuthManager = new Authorization();
	private static Enum<?> location = AuthManager.getAuthStatus() == true ? AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN : NON_AUTH_LOCATIONS_ENUM.AUTH_SCREEN;
	
	static void goBack() {
		
	}
	
	static void redirect(Enum<?>value) {
		App.location = value;
		App.showScreen();
	}
	
	static void exit() {
	}
	
	static protected HashMap<NON_AUTH_LOCATIONS_ENUM, Screen> NON_AUTH_SCREENS = new HashMap<NON_AUTH_LOCATIONS_ENUM, Screen>() {
		{
			put(NON_AUTH_LOCATIONS_ENUM.AUTH_SCREEN, new AuthScreen());
			put(NON_AUTH_LOCATIONS_ENUM.LOGIN_SCREEN, new LoginScreen());
			put(NON_AUTH_LOCATIONS_ENUM.REGISTRATION_SCREEN, new RegistrationScreen());
		}
	};

	static void updateCurrentUser(String email, String name, int age, int height, int weight) {
      // 用用户的最新数据更新 currentUser
			currentUser = new User(email, name, age, height, weight);
			// 更新 MainMenuScreen 中的 currentUser
			// 确保这里总是更新 currentUser
			AUTH_SCREENS.put(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN, new MainMenuScreen(currentUser));
	}
	
	static protected HashMap<AUTH_LOCATIONS_ENUM, Screen> AUTH_SCREENS = new HashMap<AUTH_LOCATIONS_ENUM, Screen>() {
			{
					// 在這裡傳遞 currentUser 物件
					put(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN, new MainMenuScreen(currentUser));  // 這裡傳遞 currentUser 物件
			}
	};

	static void showScreen() {
		Screen CurrentScreen;

		//TODO: add error handler
		if (App.AuthManager.getAuthStatus()) {
			CurrentScreen = AUTH_SCREENS.get(App.location);
		} else {
			CurrentScreen = NON_AUTH_SCREENS.get(App.location);
		}
		
		CurrentScreen.show();
	}
}