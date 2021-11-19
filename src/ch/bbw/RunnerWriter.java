package ch.bbw;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class RunnerWriter {
    public void writeJuniors(ArrayList<Person> persons){
        PrintWriter printWriter;

        try {
            printWriter = new PrintWriter("files/output/junioren.rl.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        printWriter.print("Rank\t");
        printWriter.print("Start-Nr.\t");
        printWriter.print("Laufzeit\t");
        printWriter.println("Name");

        int rank = 1;
        for (Person person : persons) {
            if (person.getRunnerType() == RunnerType.Junior) {
                rank = printFileLine(printWriter, rank, person);
            }
        }

        printWriter.close();
    }

    public void writeSeniors(ArrayList<Person> persons){
        PrintWriter printWriter;

        try {
            printWriter = new PrintWriter("files/output/senioren.rl.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        printWriter.print("Rank\t");
        printWriter.print("Start-Nr.\t");
        printWriter.print("Laufzeit\t");
        printWriter.println("Name");

        int rank = 1;
        for (Person person : persons) {
            if (person.getRunnerType() == RunnerType.Senior) {
                rank = printFileLine(printWriter, rank, person);
            }
        }

        printWriter.close();
    }

    public void writeElite(ArrayList<Person> persons){
        PrintWriter printWriter;

        try {
            printWriter = new PrintWriter("files/output/elite.rl.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        printWriter.print("Rank\t");
        printWriter.print("Start-Nr.\t");
        printWriter.print("Laufzeit\t");
        printWriter.println("Name");

        int rank = 1;
        for (Person person : persons) {
            if (person.getRunnerType() == RunnerType.Elite) {
                rank = printFileLine(printWriter, rank, person);
            }
        }

        printWriter.close();
    }

    public void writeName(ArrayList<Person> persons){
        PrintWriter printWriter;

        try {
            printWriter = new PrintWriter("files/output/namen.ref.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0, personsSize = persons.size(); i < personsSize; i++) {
            rankMap.put(persons.get(i).getRunnerNumber(), i);
        }

        persons.sort(Comparator.comparing(Person::getName));

        printWriter.print("Startnummer\t");
        printWriter.print("Name\t");
        printWriter.print("Kategorie\t");
        printWriter.print("Rank\t");
        printWriter.println("Laufzeit");

        for (Person person : persons) {
            printWriter.print(person.getRunnerNumber());
            printWriter.print("\t");
            printWriter.print(person.getName());
            printWriter.print("\t");
            printWriter.print(person.getRunnerType().getId());
            printWriter.print("\t");
            printWriter.print(rankMap.get(person.getRunnerNumber()));
            printWriter.print("\t");
            printWriter.println(person.getRunnerTime());
        }

        printWriter.close();
    }

    private int printFileLine(PrintWriter printWriter, int rank, Person person) {
        printWriter.print(rank);
        printWriter.print("\t");
        printWriter.print(String.format("%03d", person.getRunnerNumber()));
        printWriter.print("\t");
        printWriter.print(person.getRunnerTime());
        printWriter.print("\t");
        printWriter.println(person.getName());

        rank++;
        return rank;
    }
}
