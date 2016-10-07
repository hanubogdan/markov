/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markov;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.*;

/**
 *
 * @author HanuBogdan
 * 20-SEP-2016
 */
public class Markov {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int pas = 20;
        int pasCurent=0;
        int initialPozition = 6;
        char c;
        char cCurent;
        pasCurent = initialPozition;

        //System.out.println(s);
        //char[] test = s.toCharArray();
        String filename = "D:\\IN\\corpus.txt";
        String content = new String(Files.readAllBytes(Paths.get(filename)), "UTF-8");
        c = content.charAt(initialPozition-1);
        //System.out.println(c + " " + initialPozition);
        System.out.print(c);
        cCurent=c;
        insertCharInFile(c, "D:\\OUT\\markov-test1.txt");
        for(int i=initialPozition-1+pas; i<content.length();i++) {
            c = content.charAt(i);
            //System.out.print(c+ "" +(i+1)+" ");
            if(c==cCurent){
                c = content.charAt(i+1);
                pasCurent=i+2;
                //System.out.println(c+ "" +(i+2) +" ");
                //System.out.print(c);
                cCurent=c;
                i+=pas;
                insertCharInFile(c, "D:\\OUT\\markov-test.txt");
            }



        }
        //display(content);


        //System.out.print(countUniqueCharacters(s));
/*      aici am creat fisierul mre de corpus.txt
        File folder = new File("D:\\IN");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());

                insertStringInFile(readStringFromFile("D:\\IN\\"+listOfFiles[i].getName()), "D:\\OUT\\new.txt");
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
*/
    }
/*
    public static int countUniqueCharacters(String input) {
        String buffer = "";
        for (int i = 0; i < input.length(); i++) {
            if (!buffer.contains(String.valueOf(input.charAt(i)))) {
                buffer += input.charAt(i);
            }
        }
        return buffer.length();
    }
    */

/*
    public static long countUniqueCharacters(String input) {
        return input.chars().distinct().count();
    }
*/
/*
    public static void display(char[] c){



        for(int i=0;i<c.length;i++){
            System.out.print(c[i] + " ");

        }
    }
*/
    public static String readStringFromFile(String s) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(s)), "UTF-8");
        return content;
    }
    public static void insertStringInFile(String s, String fileNameIn){
        try
        {
            String filename= fileNameIn;
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(s+" ");//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void insertCharInFile(char s, String fileNameIn){
        try
        {
            String filename= fileNameIn;
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(s+" ");//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    public static void display (String str){

        HashMap<Character, Integer> map;
        ArrayList<HashMap<Character, Integer>> list = new ArrayList<HashMap<Character,Integer>>();
        int i;
        int x = 0;
        Boolean fire = false;

        //String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        //str = str.replaceAll("\\s", "").toLowerCase();
        System.out.println(str.length());

        for(i=0; i<str.length() ; i++){
            if(list.size() <= 0){
                map = new HashMap<Character, Integer>();
                map.put(str.charAt(i), 1);
                list.add(map);
            }else{
                map = new HashMap<Character, Integer>();
                map.put(str.charAt(i), 1);

                fire = false;

                for (HashMap<Character, Integer> t : list){
                    if(t.containsKey(str.charAt(i)) == map.containsKey(str.charAt(i))){
                        x = list.indexOf(t);
                        fire = true;

                        map.put(str.charAt(i), t.get(str.charAt(i))+1);
                    }
                }

                if(fire){
                    list.remove(x);
                }

                list.add(map);

            }
        }

        //Collections.sort(list);//sort(list);
        System.out.println(list);

    }
}
