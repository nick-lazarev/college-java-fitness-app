package Exercise;

public class RegistrationScreen extends Screen {
	private void enterEmail() {
		try {
			System.out.print("Enter email: ");
			String value = this.sc.nextLine();
			System.out.println();
			
			if (AppUtils.isValidEmail(value)) {
				App.AuthManager.setEmail(value);	
			} else {
				throw new RuntimeException("Email is not valid!");
			}
		} catch (Exception e) {
			sc.nextLine();
			System.out.println(e.getMessage());
			this.enterEmail();
			return;
		}
	}

	private void enterPassword() {
		try {
			System.out.print("Enter password: ");
			String value = this.sc.nextLine();
			System.out.println();
			
			if (AppUtils.isValidPassword(value)) {
				App.AuthManager.setPassword(value);	
			} else {
				throw new RuntimeException("Password is not valid! Password must be at least 6 characters.");
			}
		} catch (Exception e) {
			sc.nextLine();
			System.out.println(e.getMessage());
			this.enterPassword();
			return;
		}
	}

	private void enterName() {
		System.out.print("Enter name: ");
		String value = this.sc.nextLine();
		System.out.println();
		App.AuthManager.setName(value);
	}

	private void enterAge() {
		try {
			System.out.print("Enter age: ");
			
			if (!this.sc.hasNextInt()) {
				throw new RuntimeException("Error! Please enter a positive number");
			}
			int value = this.sc.nextInt();
			System.out.println();
			App.AuthManager.setAge(value);	
		} catch (Exception e) {
			sc.nextLine();
			System.out.println(e.getMessage());
			this.enterPassword();
			return;
		}
	}

	private void enterHeight() {
		try {
			System.out.print("Enter age: ");
			
			if (!this.sc.hasNextInt()) {
				throw new RuntimeException("Error! Please enter a positive number");
			}
			int value = this.sc.nextInt();
			System.out.println();
			App.AuthManager.setHeight(value);	
		} catch (Exception e) {
			sc.nextLine();
			System.out.println(e.getMessage());
			this.enterPassword();
			return;
		}
	}

	private void enterWeight() {
		try {
			System.out.print("Enter weigth: ");
			
			if (!this.sc.hasNextInt()) {
				throw new RuntimeException("Error! Please enter a positive number");
			}
			int value = this.sc.nextInt();
			System.out.println();
			App.AuthManager.setWeigth(value);	
		} catch (Exception e) {
			sc.nextLine();
			System.out.println(e.getMessage());
			this.enterPassword();
			return;
		}
	}
	
	private void nextAction() {
		App.AuthManager.register();
		App.redirect(NON_AUTH_LOCATIONS_ENUM.LOGIN_SCREEN);
	}
	
	@Override
	public void show() {
		//TODO: add error handlers
		System.out.println("Registration screen");
		System.out.println("");

		this.enterEmail();
		this.enterPassword();
		this.enterName();
		this.enterAge();
		this.enterHeight();
		this.enterWeight();

		this.nextAction();
	}
}
