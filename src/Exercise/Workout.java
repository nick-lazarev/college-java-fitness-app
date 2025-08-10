package Exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Author: Asish Anisetti (ID: N01738397)
 * Model for a workout entry (UML: workoutType, distance, set, date).
 */
public class Workout {

    private String workoutType;   // e.g., RUNNING, SQUATS, WEIGHTLIFTING
    private double distance;      // km (used for RUNNING)
    private int set;              // sets (used for SQUATS/WEIGHTLIFTING)
    private Date date;            // java.util.Date

    private static final SimpleDateFormat ISO = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public Workout() {
        this.workoutType = "RUNNING";
        this.distance = 0.0;
        this.set = 0;
        this.date = new Date();
    }

    public Workout(String type, double distanceKm, int sets, Date when) {
        setWorkoutType(type);
        setDistance(distanceKm);
        setSets(sets);
        setDate(when);
    }

    // ---- Getters/Setters (UML names) ----
    public String getWorkoutType() { return workoutType; }

    public void setWorkoutType(String newType) {
        if (newType == null || newType.isBlank()) throw new IllegalArgumentException("Type cannot be empty");
        this.workoutType = newType.trim().toUpperCase(Locale.US);
    }

    public double getDistance() { return distance; }

    public void setDistance(double newDistance) {
        if (newDistance < 0) throw new IllegalArgumentException("Distance cannot be negative");
        this.distance = newDistance;
    }

    public int getSets() { return set; }

    public void setSets(int newSets) {
        if (newSets < 0) throw new IllegalArgumentException("Sets cannot be negative");
        this.set = newSets;
    }

    public Date getDate() { return date; }

    public void setDate(Date newDate) {
        if (newDate == null) throw new IllegalArgumentException("Date cannot be null");
        this.date = newDate;
    }

    // UML requires setDate(String)
    public void setDate(String newDate) {
        try {
            this.date = ISO.parse(newDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date must be yyyy-MM-dd", e);
        }
    }

    /** Used by WorkoutManager.getTotalCalories(...) */
    double estimateCalories() {
        switch (workoutType) {
            case "RUNNING":        return distance * 60.0;
            case "SQUATS":         return set * 30.0;
            case "WEIGHTLIFTING":  return set * 40.0;
            default:               return 0.0;
        }
    }

    @Override
    public String toString() {
        String d = (date == null) ? "N/A" : ISO.format(date);
        switch (workoutType) {
            case "RUNNING":        return "RUNNING | " + String.format(Locale.US, "%.2f km", distance) + " | " + d;
            case "SQUATS":         return "SQUATS | " + set + " sets | " + d;
            case "WEIGHTLIFTING":  return "WEIGHTLIFTING | " + set + " sets | " + d;
            default:               return workoutType + " | " + d;
        }
    }
}

