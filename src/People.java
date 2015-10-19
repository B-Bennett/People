import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by BennettIronYard on 10/19/15.
 */
public class People {
    public static void main(String[] args) {

        HashMap<String, ArrayList<Person>> people = new HashMap();
        String fileContent = readFile("people.csv");
        String[] lines = fileContent.split("\n");

        int lineNum = 0;
        for (String line : lines) {
            if (lineNum != 0) { //if the line dose not equal 0. start to run

                String[] columns = line.split(",");
                int id = Integer.valueOf(columns[0]);
                String personFirstName = columns[1];
                String personLastName = columns[2];
                String personEmail = columns[3];
                String personCountry = columns[4];
                String personIpAddress = columns[5];

                Person person = new Person(Integer.valueOf(id), personFirstName, personLastName, personEmail, personCountry, personIpAddress);

                ArrayList<Person> searchList = people.get(personCountry);

                if (searchList == null) {
                    searchList = new ArrayList();
                    searchList.add(person);
                    people.put(personCountry, searchList);
                } else {
                    searchList.add(person);
                    //end of if statement
                }//end of else
            }
            lineNum++; //start on line 1
        }//end of for loop.

        for (ArrayList<Person> listPeople : people.values()) {
            Collections.sort(listPeople);
        }

        System.out.println(people);
    }//end of main

    static String readFile(String fileName) {
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        }catch (Exception e) {
            return null;
        }
    }//end readFile

    static void writeFile(String fileName, String fileContent) {
        File f = new File(fileName);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        }catch (Exception e) {

        }//end writeFile
    }//end of public static void
}//end of public class
