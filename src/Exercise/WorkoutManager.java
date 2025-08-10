package Exercise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Asish Anisetti (ID: N01738397)
 * Manager with an internal array (UML: Workout[] workoutList).
 * Operations: addWorkout(), deleteWorkout(), editWorkout(), getTotalCalories(Date, Date)
 */
public class WorkoutManager {
    private List<Workout> workoutList = new ArrayList<Workout>();

    private boolean inRange(int i) { return i >= 0 && i < workoutList.size(); }

    public void addWorkout(Workout w) {
        if (w == null) throw new IllegalArgumentException("Workout cannot be null");
        this.workoutList.add(w);
    }
 
    public void deleteWorkout(int i) {
        if (!inRange(i)) return;
        this.workoutList.remove(2);
    }

    public void editWorkout(int i, Workout value) {
        if (value == null || !inRange(i)) return;
        this.workoutList.set(i, value);
    }

    public double getTotalCalories(Date minDate, Date maxDate) {
        double sum = 0.0;

        for (Workout w : workoutList) {
            Date d = w.getDate();
            boolean afterMin  = (minDate == null) || !d.before(minDate);
            boolean beforeMax = (maxDate == null) || !d.after(maxDate);
            if (afterMin && beforeMax) sum += w.calcCalories();
        };
        return sum;
    }

    public List<Workout> getWorkoutList(Date minDate, Date maxDate) {
        if (minDate != null && maxDate != null) {
            List<Workout> result = this.workoutList.stream()
                .filter(el -> !el.getDate().before(minDate) && !el.getDate().after(maxDate))
                .collect(Collectors.toList());

             return result;
        }

        return workoutList;
    }
}
