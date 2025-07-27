package Exercise;

import java.util.LinkedHashMap;

enum OPTIONS_ENUM {
	LOGIN("Login"),
	REGISTRATION("Registration"),

	EXIT("Exit");
	
	private final String value;

	OPTIONS_ENUM(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

public class AuthScreen extends Screen {
	private final LinkedHashMap<String, OPTIONS_ENUM> OPTIONS_MAP = new LinkedHashMap<String, OPTIONS_ENUM>() {
		{
			OPTIONS_ENUM[] menuItems = OPTIONS_ENUM.values();
			for (int i = 0; i < menuItems.length; i++) {
				if (menuItems[i] == OPTIONS_ENUM.EXIT) {
					put("0", menuItems[i]);
					break;
				}

				put(Integer.toString(i + 1), menuItems[i]);
			}
		}
	};

	@Override
	public void show() {
		int option;

		System.out.println("Auth screen:");
		System.out.println("");
		for (String key: this.OPTIONS_MAP.keySet()) {
			if (this.OPTIONS_MAP.get(key) == OPTIONS_ENUM.EXIT) {
				System.out.println("");
			}
			System.out.println(key + ". " + this.OPTIONS_MAP.get(key));
		}
		
		System.out.println("");
		// TODO: add error handler
		option = sc.nextInt();
		System.out.println("");

		if (option >= 0 && option < this.OPTIONS_MAP.size()) {
			String key = Integer.toString(option);
			OPTIONS_ENUM optionValue = this.OPTIONS_MAP.get(key);
			
			if (optionValue == OPTIONS_ENUM.LOGIN) {
				App.redirect(NON_AUTH_LOCATIONS_ENUM.LOGIN_SCREEN);
			} else if (optionValue == OPTIONS_ENUM.REGISTRATION) {
				App.redirect(NON_AUTH_LOCATIONS_ENUM.REGISTRATION_SCREEN);
			} else if (optionValue == OPTIONS_ENUM.EXIT) {
				App.exit();
			}
		}
	}
}
