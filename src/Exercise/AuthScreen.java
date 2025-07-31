package Exercise;

import java.util.LinkedHashMap;

public class AuthScreen extends Screen {
	private String option;
	
	private final LinkedHashMap<String, AUTH_SCREEN_OPTIONS_ENUM> OPTIONS_MAP = new LinkedHashMap<String, AUTH_SCREEN_OPTIONS_ENUM>() {
		{
			AUTH_SCREEN_OPTIONS_ENUM[] menuItems = AUTH_SCREEN_OPTIONS_ENUM.values();
			for (int i = 0; i < menuItems.length; i++) {
				if (menuItems[i] == AUTH_SCREEN_OPTIONS_ENUM.EXIT) {
					put("0", menuItems[i]);
					break;
				}

				put(Integer.toString(i + 1), menuItems[i]);
			}
		}
	};
	
	private void renderOptions() {
		for (String key: this.OPTIONS_MAP.keySet()) {
			if (this.OPTIONS_MAP.get(key) == AUTH_SCREEN_OPTIONS_ENUM.EXIT) {
				System.out.println("");
			}
			System.out.println(key + ". " + this.OPTIONS_MAP.get(key));
		}
	}
	
	//TODO: fix empty line after enter
	private void enterOption() {
		try {
			System.out.println("");
			this.option = sc.nextLine();

			if (!this.OPTIONS_MAP.containsKey(this.option)) {
				throw new RuntimeException("Error! Please enter an option number");
			}
			
			System.out.println("");
		} catch (Exception e) {
			sc.nextLine();
			System.out.println(e.getMessage());
			this.enterOption();
			return;
		}
	}
	
	private void nextAction() {
		AUTH_SCREEN_OPTIONS_ENUM optionValue = this.OPTIONS_MAP.get(this.option);
		
		if (optionValue == AUTH_SCREEN_OPTIONS_ENUM.LOGIN) {
			App.redirect(NON_AUTH_LOCATIONS_ENUM.LOGIN_SCREEN);
		} else if (optionValue == AUTH_SCREEN_OPTIONS_ENUM.REGISTRATION) {
			App.redirect(NON_AUTH_LOCATIONS_ENUM.REGISTRATION_SCREEN);
		} else if (optionValue == AUTH_SCREEN_OPTIONS_ENUM.EXIT) {
			App.exit();
		}
	}

	@Override
	public void show() {
		System.out.println("Auth screen");
		System.out.println("");
		
		this.renderOptions();
		this.enterOption();
		this.nextAction();
	}
}
