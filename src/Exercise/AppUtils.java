package Exercise;

import java.util.regex.Matcher;

public class AppUtils {
	public static final boolean isValidEmail(String value) {
		Matcher matcher = AppContants.EMAIL_REGEXP.matcher(value);
		return matcher.matches();
	}

	public static final boolean isValidPassword(String value) {
		Matcher matcher = AppContants.PASSWORD_REGEXP.matcher(value);
		return matcher.matches();
	}
}
