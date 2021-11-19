package ch.bbw;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RunnerReader runnerReader = new RunnerReader();

        ArrayList<Person> people = runnerReader.GetRunners();

        RunnerWriter runnerWriter = new RunnerWriter();

        runnerWriter.writeJuniors(people);
        runnerWriter.writeSeniors(people);
        runnerWriter.writeElite(people);
        runnerWriter.writeName(people);
    }
}
