package Exercise;

enum TOTAL_CALORIES_SCREEN_OPTIONS_ENUM {
	TOTAL("Get for all time"),
	ENTER_DATES("Enter dates"),

	BACK("Go back");
	
	private final String value;

	TOTAL_CALORIES_SCREEN_OPTIONS_ENUM(String value) {
      this.value = value;
  }

  @Override
  public String toString() {
      return value;
  }
}
