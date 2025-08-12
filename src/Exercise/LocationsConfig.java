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
    MAIN_MENU_SCREEN("mainMenu"),
    USER_SCREEN("mainMenu/userInfo"),
    WORKOUT_LIST_SCREEN("mainMenu/workoutList"),
    LOG_WORKOUT_SCREEN("mainMenu/logWorkout"),
    TOTAL_CALORIES_SCREEN("mainMenu/totalCalories");

    private final String value;

    AUTH_LOCATIONS_ENUM(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
