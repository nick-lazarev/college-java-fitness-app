package Exercise;

import java.util.Date;
import java.util.List;

public class WorkoutApp {
    public static void main(String[] args) {
        WorkoutManager mgr = new WorkoutManager();

        Workout run = new Workout();
        run.setWorkoutType(WORKOUT_TYPES_ENUM.RUNNING);
        run.setDistance(5.0);         // 5 km
        run.setDate("2025-08-09");    // yyyy-MM-dd
        mgr.addWorkout(run);

        Workout lift = new Workout();
        lift.setWorkoutType(WORKOUT_TYPES_ENUM.WEIGHTLIFTING);
        lift.setSets(12);             // 12 sets
        lift.setDate(new Date());     // today
        mgr.addWorkout(lift);

        List<Workout> workoutList = mgr.getWorkoutList(null, null);
        System.out.println("Workouts count : " + workoutList.size());
        System.out.println("Total calories : " + mgr.getTotalCalories(null, null));
        for (Workout w : workoutList) System.out.println(" - " + w);
    }
}
