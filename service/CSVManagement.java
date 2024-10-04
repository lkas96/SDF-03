package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import group.Group;

public class CSVManagement {
    
    //filename : directoryPath + file seperator +filename
    public List<Group> readCSV(String filename) throws IOException{
        //Use BufferReader
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        List<Group> groups = new ArrayList<>();

        String line = "";

        while ((line = br.readLine()) != null){
            
            //Prints the csv line by line but in string
            System.out.print(line);

            //Spilt the line, seperately by the comma
            //groupname, type group, year format in the csv
            String[] lineData = line.split(",");

            //Put the extracted csv into a Group object
            //groupname, type group, year format in the csv
            //lineData[0] , lineData[1], lineData[2]
            Group g = new Group(lineData[0], lineData[1], Integer.parseInt(lineData[2].trim()));
            groups.add(g);


        }
        System.out.println(""); //line breaK

        br.close();
        fr.close();

        return groups;
        

    }

    public void writeCSV(String dirFile, List<Group> groups) throws IOException{
        //Use BufferedWriter

        FileWriter fw = new FileWriter(dirFile, false);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (Group g: groups){
            bw.append(g.getGroup());
            bw.append(",");
            bw.append(g.getType());
            bw.append(",");
            bw.append(g.getYear().toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        fw.close();

    }

}
