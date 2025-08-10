package Exercise;

import java.util.Date;

public class WorkoutApp {
    public static void main(String[] args) {
        WorkoutManager mgr = new WorkoutManager();

        Workout run = new Workout();
        run.setWorkoutType("RUNNING");
        run.setDistance(5.0);         // 5 km
        run.setDate("2025-08-09");    // yyyy-MM-dd
        mgr.addWorkout(run);

        Workout lift = new Workout();
        lift.setWorkoutType("WEIGHTLIFTING");
        lift.setSets(12);             // 12 sets
        lift.setDate(new Date());     // today
        mgr.addWorkout(lift);

        System.out.println("Workouts count : " + mgr.count());
        System.out.println("Total calories : " + mgr.getTotalCalories(null, null));
        for (Workout w : mgr.toArray()) System.out.println(" - " + w);
    }
}
