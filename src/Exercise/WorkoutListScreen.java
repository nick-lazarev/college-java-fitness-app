package Exercise;

public class WorkoutListScreen extends WorkoutScreen {
    @Override
    public void show() {
        System.out.println("");
        System.out.println("WorkoutScreen: ");
        System.out.println("");

        this.renderOptions();
        this.enterOption();
        this.handleOption();
        this.renderWorkoutList();

        this.setDefaultSettings();
        this.show();
    }
}
