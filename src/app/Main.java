package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        
        Map<String, Integer> votes = new LinkedHashMap<>();
        String path = "/home/lucas/eclipse-workspace/map2-java/input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(", ");
                String name = fields[0];
                Integer count = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)) {
                    int voteSoFar = votes.get(name);
                    votes.put(name, count + voteSoFar);
                }

                else {
                    votes.put(name, count);
                }

                line = br.readLine();
            }

            System.out.println("Total votes:");
            for (String key: votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}