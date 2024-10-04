import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import group.Group;
import service.CSVManagement;


public class App {

    public static void main(String[] args) throws IOException{

        //arg[0] arg[1] arg[2]
        //Windows directory C:\data\myfiles.txt

        String directoryPath    = args[0]; //C:\data
        String fileName         = args[1]; //myfiles.txt
        String dirFile = directoryPath + File.separator + fileName;
        
        // //File.separator function add a \
        // //If not directoryPathFileName when combined it is C:\datamyfiles.txt

        // //Check if a directory exists
        // //If does not exists, create the directory
        File directory = new File(directoryPath);

        if (directory.exists()){
            System.out.println("Directory " + directory.toString() + " already exsist.");
        } else {
            directory.mkdir();
            System.out.println("Directory " + directory.toString() + " has been created.");
            //creates a directory, which is specified C:\data
        }

        // //Check if file exists
        //If not create the file
        File file = new File(dirFile);

        if (file.exists()){
            System.out.println("File " + file.toString() + " already exists.");

        } else {
            file.createNewFile(); //creates a new file with that filename specified
            System.out.println("File " + file.toString() + " has been created.");
        }

        // //Using file writer
        // //1. Use console to read in a string of text/sentence
        // //2. Use FileWriter to write the contents to the file that has been created.

        // Console console = System.console();
        // String keyboardInput = console.readLine("Enter/Input a sentence: "); 

        // //Example 1
        // // FileWriter fw = new FileWriter(file, true); //Append adds new lines to the text file.
        // // fw.write(keyboardInput);
        // // fw.flush();
        // // fw.close();

        // // //Using FileReader to read a file
        // // FileReader fr = new FileReader(file);
        // // int dataRead = fr.read();               //Each character is represent in ASCII code, hence int type
        // // while (dataRead != -1) {                //if there are still things to read, -1 means end of file nothing to read
        // //     System.out.print((char) dataRead); //Prints out what is read from the file
        // //     dataRead = fr.read();
        // // }
        // // fr.close();
 
        // //Example 2
        // //Use BufferedWrtier to write to file
        // // FileWriter fw = new FileWriter(file, true);
        // // BufferedWriter bw = new BufferedWriter(fw);
        // // bw.append(keyboardInput);
        // // bw.flush();
        // // bw.close();
        // // fw.close();

        // //Use BufferedReader to file the file content
        // // FileReader fr = new FileReader(file);
        // // BufferedReader br = new BufferedReader(fr);
        // // String line = "";

        // // while ((line = br.readLine()) != null) {
        // //     System.out.println();
        // // }
        // // br.close();
        // // fr.close();

        // // //Alternate method, using try, dont need to close the reader/streamer objects
        // // try (FileReader fr = new FileReader(file)){
        // //     try (BufferedReader br = new BufferedReader(fr)){
        // //         String line = "";
        // //         while ((line = br.readLine()) != null) {
        // //             System.out.println();
        // //         }
        // //     }
        // // }



        // //Example 3
        // //Use FileOutputStream to write to file content
        // // FileOutputStream fos = new FileOutputStream(file, true);
        // // byte[] byteContent  = keyboardInput.getBytes();
        // // fos.write(byteContent);
        // // fos.flush();
        // // fos.close();

        // // //Use FileInputStream to read the file content
        // // FileInputStream fis = new FileInputStream(file);
        // // int contentRead = 0;
        // // while ((contentRead = fis.read()) != -1) {
        // //     System.out.print((char) contentRead);
        // // }
        // // fis.close();

        // //Example 4 (Decorator Pattern)
        // //Use FileOutputStream and DataOutputStream to write to file
        // FileOutputStream fos = new FileOutputStream(file, true);
        // DataOutputStream dos = new DataOutputStream(fos);
        // byte[] contentRead = keyboardInput.getBytes();
        // dos.write(contentRead);
        // dos.close();
        // fos.close();

        // //Use FileInputStream and DataInputStream to read the content
        // FileInputStream fis = new FileInputStream(file);
        // DataInputStream dis = new DataInputStream(fis);
        // int contentReaded ;
        // while((contentReaded = dis.read()) != -1){
        //     System.out.print((char) contentReaded);
        // }
        // dis.close();
        // fis.close();







        //Group csv file read
        // String dirPathFileName = args[0]; //take in filename and path from argument

        List<Group> groups = new ArrayList<>();

        CSVManagement csv = new CSVManagement();
        groups = csv.readCSV(dirFile);

        //menu
        //1. Enter new person details
        //2. save to file (prompt to save newcsv filename)
        //3. quit terminate programme


        Console consoleSelection = System.console();
        Integer selection = 0;

        while (selection != 3){
            System.out.println("Welcome to KPOP GROUP Management");
            System.out.println("---------------------------------");
            System.out.println("To add a KPOP group profile, Press 1.");
            System.out.println("To save to new csv file , Press 2.");
            System.out.println("To quit this programme, Press 3.");
            selection = Integer.parseInt(consoleSelection.readLine("What is your selection? : "));

            switch (selection){
                case 1:
                    Console con1 = System.console();
                    String groupName = con1.readLine("Enter group name: ");
                    String groupType = con1.readLine("Enter group type (Kpop/Global Pop): ");
                    String groupDebutYear = con1.readLine("Enter group debut year: ");

                    Group g = new Group(groupName, groupType, Integer.parseInt(groupDebutYear));
                    groups.add(g);

                    break;

                case 2:
                    Console con2 = System.console();
                    String newFileName = con2.readLine("Enter new filename for the CSV file: ");
                    csv.writeCSV(directoryPath + File.separator + newFileName, groups);
                    break;

                default:
                    break;
            }
        }

            
        


    }


}