package Exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;

public class AppUtils {
	static Scanner sc = new Scanner(System.in);
  static SimpleDateFormat ISO = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

	public static final boolean isValidEmail(String value) {
		Matcher matcher = AppContants.EMAIL_REGEXP.matcher(value);
		return matcher.matches();
	}

	public static final boolean isValidPassword(String value) {
		Matcher matcher = AppContants.PASSWORD_REGEXP.matcher(value);
		return matcher.matches();
	}

	public static Date enterDate(String msg) {
			try {
					System.out.println();
					System.out.print(msg);

					String value = AppUtils.sc.nextLine();
					return ISO.parse(value);
			} catch (ParseException e) {
					System.out.println("Date must be yyyy-MM-dd");
					return AppUtils.enterDate(msg);
			}
  }

	public static int enterPositiveInt(String msg) {
		try {
        System.out.println();
        System.out.print(msg);

				if (!AppUtils.sc.hasNextInt()) {
						throw new RuntimeException("Error! Please enter a positive integer");
				}
				int value = AppUtils.sc.nextInt();
				if (value <= 0) {
						throw new RuntimeException("Error! Please enter a positive integer");
				}

				AppUtils.sc.nextLine();
				return value;  
		} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
				return AppUtils.enterPositiveInt(msg);
		}
  }
	
	public static double enterPositiveDouble(String msg) {
		try {
        System.out.print(msg);

				if (!AppUtils.sc.hasNextDouble()) {
						throw new RuntimeException("Error! Please enter a positive double");
				}
				double value = AppUtils.sc.nextDouble();
				if (value <= 0) {
						throw new RuntimeException("Error! Please enter a positive integer");
				}

				AppUtils.sc.nextLine();
				return value;  
		} catch (Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
				return AppUtils.enterPositiveDouble(msg);
		}
  }
	
	public static String enterEmail() {
			try {
          System.out.println();
					System.out.print("Enter email: ");
					String value = AppUtils.sc.nextLine();
					
					if (AppUtils.isValidEmail(value)) {
							return value;
					} else {
							throw new RuntimeException("Email is not valid!");
					}
			} catch (Exception e) {
					System.out.println(e.getMessage());
					return AppUtils.enterEmail();
			}
	}

	public static String enterPassword() {
			try {
          System.out.println();
					System.out.print("Enter password: ");
					String value = AppUtils.sc.nextLine();
					
					if (AppUtils.isValidPassword(value)) {
							return value;
					} else {
							throw new RuntimeException("Password is not valid! Password must be at least 6 characters.");
					}
			} catch (Exception e) {
					System.out.println(e.getMessage());
					return AppUtils.enterPassword();
			}
	}
}
