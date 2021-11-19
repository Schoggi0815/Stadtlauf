package ch.bbw;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class RunnerReader {
    public ArrayList<Person> GetRunners(){
        // Open files
        FileReader resultsFileReader;
        FileReader listFileReader;
        try {
            resultsFileReader = new FileReader("files/input/messresultate.txt");
            listFileReader = new FileReader("files/input/startliste.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        // Create buffered Readers
        BufferedReader resultsBufferedReader = new BufferedReader(resultsFileReader);
        BufferedReader listBufferedReader = new BufferedReader(listFileReader);

        // Create HashMap and ArrayList
        HashMap<Integer, LocalTime> resultMap = new HashMap<>();
        ArrayList<Person> persons = new ArrayList<>();

        String line;

        try {
            // Read messresultate.txt
            while ((line = resultsBufferedReader.readLine()) != null){
                String runnerNumberString = line.substring(0, 3).trim();
                String endTimeString = line.substring(4);

                int runnerNumber = Integer.parseInt(runnerNumberString);
                LocalTime endTime = LocalTime.parse(endTimeString);

                resultMap.put(runnerNumber, endTime);
            }

            // Read startliste.txt
            while ((line = listBufferedReader.readLine()) != null){
                String runnerNumberString = line.substring(0, 3).trim();
                String runnerTypeNumberString = line.substring(4, 5);
                String name = line.substring(6);

                int runnerNumber = Integer.parseInt(runnerNumberString);
                RunnerType runnerType = RunnerType.values()[Integer.parseInt(runnerTypeNumberString) - 1];
                if (resultMap.containsKey(runnerNumber)){
                    persons.add(new Person(name, Duration.between(resultMap.get(runnerNumber), runnerType.getStartTime()), runnerNumber, runnerType));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }

        // Läufer nach Rang sortieren
        persons.sort(Comparator.comparing(Person::getRunnerTime));

        return persons;
    }
}
