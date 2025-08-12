package Exercise;

enum LOG_WORKOUT_SCREEN_OPTIONS_ENUM {
	TOTAL("Get for all time"),
	ENTER_DATES("Enter dates"),

	BACK("Go back");
	
	private final String value;

	LOG_WORKOUT_SCREEN_OPTIONS_ENUM(String value) {
      this.value = value;
  }

  @Override
  public String toString() {
      return value;
  }
}
