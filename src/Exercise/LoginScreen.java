package Exercise;

public class LoginScreen extends Screen {
    private void enterEmail() {
        try {
            System.out.print("Enter email: ");
            String value = this.sc.nextLine();
            System.out.println();
            
            if (AppUtils.isValidEmail(value)) {
                App.authManager.setEmail(value);
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
                App.authManager.setPassword(value);
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

    private void nextAction() {
        App.authManager.login();  
        App.redirect(AUTH_LOCATIONS_ENUM.MAIN_MENU_SCREEN);
    }
    
    @Override
    public void show() {
        System.out.println("Login screen");
        System.out.println("");

        this.enterEmail();
        this.enterPassword();
        this.nextAction(); 
    }
}
