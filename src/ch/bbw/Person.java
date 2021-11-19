package ch.bbw;

import java.time.Duration;

public class Person {
    private String name;
    private Duration runnerTime;
    private int runnerNumber;
    private RunnerType runnerType;

    public Person(String name, Duration runnerTime, int runnerNumber, RunnerType runnerType) {
        this.name = name;
        this.runnerTime = runnerTime;
        this.runnerNumber = runnerNumber;
        this.runnerType = runnerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getRunnerTime() {
        return runnerTime;
    }

    public void setRunnerTime(Duration runnerTime) {
        this.runnerTime = runnerTime;
    }

    public int getRunnerNumber() {
        return runnerNumber;
    }

    public void setRunnerNumber(int runnerNumber) {
        this.runnerNumber = runnerNumber;
    }

    public RunnerType getRunnerType() {
        return runnerType;
    }

    public void setRunnerType(RunnerType runnerType) {
        this.runnerType = runnerType;
    }
}
