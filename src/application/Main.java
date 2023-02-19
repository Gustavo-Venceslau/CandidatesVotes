package application;

import entities.Candidates;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        File path = new File("/Users/gustavodealmeida/documents/doc.txt");
        Map<Candidates,Integer> allCandidates = new LinkedHashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                String[] lineInfo = line.split(",");
                String name = lineInfo[0];
                int votes = Integer.parseInt(lineInfo[1]);
                Candidates candidate = new Candidates(name, votes);
                if(allCandidates.containsKey(candidate)){
                    int candidateVotes = allCandidates.get(candidate);
                    allCandidates.put(candidate, votes + candidateVotes);
                }
                else{
                    allCandidates.put(candidate, votes);
                }
                line = br.readLine();
            }
            Set<Candidates> keys = allCandidates.keySet();

            for(Candidates p: keys){
                System.out.println(p.getName() + ": " + allCandidates.get(p));
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}