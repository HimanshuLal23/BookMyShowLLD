package Model;

import java.time.LocalTime;

public class Time {
    private LocalTime startTime;
    private LocalTime endTime;

    public Time(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
