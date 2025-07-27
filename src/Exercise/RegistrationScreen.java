package Exercise;

public class RegistrationScreen extends Screen {
	@Override
	public void show() {
		//TODO: add error handlers
		System.out.println("Registration screen:");
		System.out.println("");
		System.out.print("Enter email: ");
		App.AuthManager.setEmail(this.sc.nextLine());
		System.out.println();

		System.out.print("Enter password: ");
		App.AuthManager.setPassword(this.sc.nextLine());
		System.out.println();
		
		System.out.print("Enter name: ");
		App.AuthManager.setPassword(this.sc.nextLine());
		System.out.println();

		System.out.print("Enter age: ");
		App.AuthManager.setAge(this.sc.nextInt());
		this.sc.nextLine();
		System.out.println();

		System.out.print("Enter height: ");
		App.AuthManager.setHeight(this.sc.nextInt());
		this.sc.nextLine();
		System.out.println();

		System.out.print("Enter weigth: ");
		App.AuthManager.setWeigth(this.sc.nextInt());
		this.sc.nextLine();
		System.out.println();

		App.AuthManager.register();
		App.redirect(NON_AUTH_LOCATIONS_ENUM.LOGIN_SCREEN);
	}
}
