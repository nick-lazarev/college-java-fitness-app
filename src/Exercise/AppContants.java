package Exercise;

import java.util.regex.Pattern;

public class AppContants {
	public static final Pattern EMAIL_REGEXP = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static final Pattern PASSWORD_REGEXP = 
		    Pattern.compile(".{6,}", Pattern.CASE_INSENSITIVE);
		
	public static final String LOCATION_DELIMETER = "/"; 
}
