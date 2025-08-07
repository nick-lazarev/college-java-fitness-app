package Exercise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Workoutmanager {
    private List<workout> workoutList;

    public Workoutmanager() {
        workoutList = new ArrayList<>();
    }

    public void addWorkout(workout workout) {
        if (workout != null) {
            workoutList.add(workout);
        }
    }

    public void deleteWorkout(int index) {
        if (index >= 0 && index < workoutList.size()) {
            workoutList.remove(index);
        }
    }

    public boolean editWorkout(int index, workout updatedWorkout) {
        if (index >= 0 && index < workoutList.size()) {
            workoutList.set(index, updatedWorkout);
            return true;
        }
        return false;
    }

    public List<workout> getAllWorkouts() {
        return new ArrayList<>(workoutList);
    }

    public workout getWorkoutAt(int index) {
        if (index >= 0 && index < workoutList.size()) {
            return workoutList.get(index);
        }
        return null;
    }

    public double getTotalCalories(Date minDate, Date maxDate) {
        double totalCalories = 0;

        for (workout w : workoutList) {
            Date d = w.getDate();
            if ((d.after(minDate) || d.equals(minDate)) && (d.before(maxDate) || d.equals(maxDate))) {
                totalCalories += calculateCalories(w);
            }
        }

        return totalCalories;
    }

    private double calculateCalories(workout w) {
        String type = w.getWorkoutType().toLowerCase();

        switch (type) {
            case "running":
                return w.getDistance() * 80;
            case "cycling":
                return w.getDistance() * 60;
            case "weightlifting":
                return w.getSets() * 10;
            default:
                return (w.getDistance() * 50) + (w.getSets() * 5); // hybrid fallback
        }
    }

    public int getWorkoutCount() {
        return workoutList.size();
    }
}
