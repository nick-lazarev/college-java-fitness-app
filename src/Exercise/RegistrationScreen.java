package Exercise;

public class RegistrationScreen extends Screen {
    private void enterEmail() {
        App.authManager.setEmail(AppUtils.enterEmail());
    }

    private void enterPassword() {
        App.authManager.setPassword(AppUtils.enterPassword());
    }

    private void enterName() {
        try {
            System.out.println();
            System.out.print("Enter name: ");
            String name = this.sc.nextLine().trim();

            if (name.isEmpty()) {
                throw new RuntimeException("Name is not valid!");
            } 

            App.authManager.setName(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.enterName();
        }
    }

    private void enterAge() {
        App.authManager.setAge(AppUtils.enterPositiveInt("Enter age: "));
    }

    private void enterHeight() {
        App.authManager.setHeight(AppUtils.enterPositiveInt("Enter height (in cm): "));
    }

    private void enterWeight() {
        App.authManager.setWeight(AppUtils.enterPositiveInt("Enter weight (in kg): "));
    }
    
    private void nextAction() {
        App.authManager.register();
        App.redirect(NON_AUTH_LOCATIONS_ENUM.LOGIN_SCREEN);
    }
    
    @Override
    public void show() {
        System.out.println("");
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
