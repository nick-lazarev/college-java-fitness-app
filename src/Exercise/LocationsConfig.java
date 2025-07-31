package Exercise;

enum NON_AUTH_LOCATIONS_ENUM {
	AUTH_SCREEN("auth"),
	LOGIN_SCREEN("auth/login"),
	REGISTRATION_SCREEN("auth/registration");
	
	private final String value;

	NON_AUTH_LOCATIONS_ENUM(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

enum AUTH_LOCATIONS_ENUM {
	MAIN_MENU_SCREEN("mainMenu");
	
	private final String value;

	AUTH_LOCATIONS_ENUM(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
