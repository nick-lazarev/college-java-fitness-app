package Exercise;

public class LoginScreen extends Screen {
	@Override
	public void show() {
		//TODO: add password, email validation
		System.out.println("Login screen:");
		System.out.println("");
		System.out.print("Enter email: ");
		App.AuthManager.setEmail(this.sc.nextLine());
		System.out.println();

		System.out.print("Enter password: ");
		App.AuthManager.setPassword(this.sc.nextLine());
		System.out.println();

		App.AuthManager.login();
		App.redirect(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN);
	}
}
