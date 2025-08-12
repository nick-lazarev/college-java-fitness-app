package Exercise;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Author: Asish Anisetti (ID: N01738397)
 * Model for a workout entry (UML: workoutType, distance, set, date).
 */
public class Workout {
    private WORKOUT_TYPES_ENUM workoutType;   // e.g., RUNNING, SQUATS, WEIGHTLIFTING
    private double distance;      // km (used for RUNNING)
    private int setsAmount;              // sets (used for SQUATS/WEIGHTLIFTING)
    private Date date;      // java.util.Date

    Workout() {

    }

    Workout(
        WORKOUT_TYPES_ENUM workoutType,
        double distance,
        int setsAmount,
        Date date
    ) {
        this.workoutType = workoutType;
        this.distance = distance;
        this.setsAmount = setsAmount;
        this.date = date;
    }

    // ---- Getters/Setters (UML names) ----
    public WORKOUT_TYPES_ENUM getWorkoutType() {
        return this.workoutType;
    }

    public void setWorkoutType(WORKOUT_TYPES_ENUM newType) {
        this.workoutType = newType;
    }

    public double getDistance() { return this.distance; }

    public void setDistance(double newDistance) {
        if (newDistance < 0) throw new IllegalArgumentException("Distance cannot be negative");
        this.distance = newDistance;
    }

    public int getSets() { return setsAmount; }

    public void setSets(int newSets) {
        if (newSets < 0) throw new IllegalArgumentException("Sets cannot be negative");
        this.setsAmount = newSets;
    }

    public Date getDate() { return date; }

    public void setDate(Date newDate) {
        if (newDate == null) throw new IllegalArgumentException("Date cannot be null");
        this.date = newDate;
    }

    // UML requires setDate(String)
    public void setDate(String newDate) {
        try {
            this.date = AppUtils.ISO.parse(newDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date must be yyyy-MM-dd", e);
        }
    }

    /** Used by WorkoutManager.getTotalCalories(...) */
    double calcCalories() {
        switch (workoutType) {
            case WORKOUT_TYPES_ENUM.RUNNING:
                return this.distance * 60.0;

            case WORKOUT_TYPES_ENUM.SQUATS:
                return this.setsAmount * 30.0;

            case WORKOUT_TYPES_ENUM.WEIGHTLIFTING:
                return this.setsAmount * 40.0;

            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        String d = (date == null) ? "N/A" : AppUtils.ISO.format(date);
        switch (workoutType) {
            case WORKOUT_TYPES_ENUM.RUNNING:
                return "RUNNING | " + String.format(Locale.US, "%.2f km", this.distance) + " | " + d;

            case WORKOUT_TYPES_ENUM.SQUATS:
                return "SQUATS | sets: " + this.setsAmount + " | " + d;

            case WORKOUT_TYPES_ENUM.WEIGHTLIFTING:
                return "WEIGHTLIFTING | sets: " + this.setsAmount + " | " + d;

            default:
                return "Workout type is absent" + " | " + d;
        }
    }
}

