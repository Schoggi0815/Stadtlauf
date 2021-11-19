package ch.bbw;

import java.time.LocalDateTime;
import java.time.LocalTime;

public enum RunnerType {
    Junior(LocalTime.of(14, 0), 1),
    Senior(LocalTime.of(14, 15), 2),
    Elite(LocalTime.of(15, 0), 3);

    RunnerType(LocalTime startTime, int id) {
        this.startTime = startTime;
        this.id = id;
    }

    private final LocalTime startTime;
    private final int id;

    public LocalTime getStartTime() {
        return startTime;
    }

    public int getId() {
        return id;
    }
}
