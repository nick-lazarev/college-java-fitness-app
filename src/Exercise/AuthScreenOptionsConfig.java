package Exercise;

enum AUTH_SCREEN_OPTIONS_ENUM {
	LOGIN("Login"),
	REGISTRATION("Registration"),

	EXIT("Exit");
	
	private final String value;

	AUTH_SCREEN_OPTIONS_ENUM(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
