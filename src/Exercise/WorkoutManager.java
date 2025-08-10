package Exercise;

import java.util.Arrays;
import java.util.Date;

/**
 * Author: Asish Anisetti (ID: N01738397)
 * Manager with an internal array (UML: Workout[] workoutList).
 * Operations: addWorkout(), deleteWorkout(), editWorkout(), getTotalCalories(Date, Date)
 */
public class WorkoutManager {

    private Workout[] workoutList = new Workout[8];
    private int size = 0;

    private void ensureCap(int need) {
        if (need <= workoutList.length) return;
        int newCap = Math.max(need, workoutList.length * 2);
        workoutList = Arrays.copyOf(workoutList, newCap);
    }

    private boolean inRange(int idx) { return idx >= 0 && idx < size; }

    public void addWorkout(Workout w) {
        if (w == null) throw new IllegalArgumentException("Workout cannot be null");
        ensureCap(size + 1);
        workoutList[size++] = w;
    }


    public boolean deleteWorkout() {
        if (size == 0) return false;
        workoutList[--size] = null;
        return true;
    }

 
    public boolean deleteWorkout(int index) {
        if (!inRange(index)) return false;
        for (int i = index; i < size - 1; i++) workoutList[i] = workoutList[i + 1];
        workoutList[--size] = null;
        return true;
    }

    public boolean editWorkout(int index, Workout updated) {
        if (updated == null || !inRange(index)) return false;
        workoutList[index] = updated;
        return true;
    }

    public double getTotalCalories(Date minDate, Date maxDate) {
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            Workout w = workoutList[i];
            Date d = w.getDate();
            boolean afterMin  = (minDate == null) || !d.before(minDate);
            boolean beforeMax = (maxDate == null) || !d.after(maxDate);
            if (afterMin && beforeMax) sum += w.estimateCalories();
        }
        return sum;
    }

    // Helpers for UI/tests
    public int count() { return size; }
    public Workout[] toArray() { return Arrays.copyOf(workoutList, size); }
}
