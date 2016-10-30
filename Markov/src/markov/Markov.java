/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markov;

import org.apache.commons.lang.StringUtils;

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

        double za2 = 1.96d;
        double pCaciula = 0.097379d;
        double nMare = 13658d;
       // eRP1P2(nMare,za2,pCaciula);
        double test=0d;
       // test =Math.sqrt(pCaciula/(1-pCaciula));
        //      System.out.print(test+"     "+Math.sqrt(test));
       // er=zAlfa*1/Math.sqrt(n*pCaciula/(1-pCaciula));
        //System.out.print("er="+ za2/5.17);


    //Nreper*pCaciula*(1-pCaciula)>20

        //String[] vector ={"EA", "E$", "E@", "EB", "EC", "ED", "EE", "EF", "EG", "EH", "EI", "E^", "EJ", "EK", "EL", "EM", "EN", "EO", "EP", "EQ", "ER", "ES", "E#", "ET", "E~", "EU", "EV", "EW", "EX", "EY", "EZ", "E ", "E.", "E%", "E}", "E-", "E{", "E*", "E,", "E:", "E;", "E?", "E!", "E\"", "E(", "E)", "E'"};
        String[] vector1 = {"A", "$", "@", "B", "C", "D", "E", "F", "G", "H", "I", "^", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "#", "T", "~", "U", "V", "W", "X", "Y", "Z", " ", ".", "%", "}", "-", "{", "*", ",", ":", ";", "?", "!", "\"", "(", ")", "'"};
        String[] vector2 = {"A", "$", "@", "B", "C", "D", "E", "F", "G", "H", "I", "^", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "#", "T", "~", "U", "V", "W", "X", "Y", "Z", " ", ".", "%", "}", "-", "{", "*", ",", ":", ";", "?", "!", "\"", "(", ")", "'"};

        //String[] vector = {"EA", "EB", "EC", "ED", "EE", "EF", "EG", "EI", "EJ", "EL", "EM", "EN", "EO", "EP", "ER", "ES", "ET", "EU", "EV", "EX", "EZ", "E#", "E~", "E ", "E.", "E,", "E:", "E?", "E!", "E-"};
        //String[] vector = {"AB", "AC", "AD", "AF", "AG", "AH", "AI", "AJ", "AL", "AM", "AN", "AP", "AR", "AS", "AT", "AU", "AV", "AZ", "A#", "A~", "A ", "A.", "A,", "A-", "BA", "BE", "BI", "BL", "BO", "BR", "BS", "BU", "B$", "B ", "CA", "CE", "CH", "CI", "CL", "CO", "CR", "CT", "CU", "C$", "C@", "C~", "C ", "C.", "C,", "DA", "DE", "DI", "DO", "DR", "DU", "D$", "D ", "D,", "EA", "EB", "EC", "ED", "EE", "EF", "EG", "EI", "EJ", "EL", "EM", "EN", "EO", "EP", "ER", "ES", "ET", "EU", "EV", "EX", "EZ", "E#", "E~", "E ", "E.", "E,", "E:", "E?", "E!", "E-", "FA", "FE", "FI", "FL", "FO", "FR", "FU", "F$", "F@", "GA", "GE", "GH", "GI", "GL", "GO", "GR", "GU", "G$", "G@", "G ", "HA", "HE", "HI", "HO", "IA", "IB", "IC", "ID", "IE", "IF", "IG", "II", "IJ", "IL", "IM", "IN", "IO", "IP", "IR", "IS", "IT", "IU", "IV", "IZ", "I#", "I~", "I ", "I.", "I,", "I?", "I-", "JA", "JE", "JI", "JO", "JU", "KA", "KI", "LA", "LB", "LC", "LD", "LE", "LI", "LL", "LN", "LO", "LT", "LU", "L$", "L@", "L~", "L ", "L.", "L,", "L-", "MA", "MB", "ME", "MI", "MN", "MO", "MP", "MU", "M$", "M@", "M~", "M ", "M,", "M-", "NA", "NC", "ND", "NE", "NF", "NG", "NI", "NO", "NS", "NT", "NU", "NV", "NZ", "N$", "N~", "N ", "N.", "N,", "N-", "OA", "OB", "OC", "OD", "OF", "OG", "OI", "OL", "OM", "ON", "OP", "OR", "OS", "OT", "OU", "OV", "OZ", "O#", "O~", "O ", "PA", "PE", "PI", "PL", "PO", "PR", "PT", "PU", "P$", "P@", "P ", "RA", "RB", "RC", "RD", "RE", "RF", "RG", "RI", "RL", "RM", "RN", "RO", "RP", "RR", "RS", "RT", "RU", "RV", "RZ", "R$", "R@", "R#", "R~", "R ", "R.", "R,", "R-", "SA", "SC", "SE", "SF", "SI", "SM", "SO", "SP", "ST", "SU", "S$", "S@", "S ", "S.", "S,", "S-", "TA", "TE", "TF", "TH", "TI", "TO", "TR", "TU", "T$", "T@", "T ", "T.", "T,", "T-", "UA", "UB", "UC", "UD", "UF", "UG", "UI", "UL", "UM", "UN", "UP", "UR", "US", "UT", "UV", "UZ", "U$", "U#", "U~", "U ", "U.", "U,", "U-", "VA", "VE", "VI", "VO", "VR", "VU", "V$", "V@", "V ", "XI", "Y ", "ZA", "ZB", "ZE", "ZI", "ZO", "ZU", "Z$", "Z@", "Z ", "$B", "$C", "$D", "$G", "$I", "$L", "$M", "$N", "$P", "$R", "$S", "$T", "$U", "$Z", "$#", "$~", "$ ", "$.", "$,", "$:", "$-", "@I", "@L", "@M", "@N", "@R", "@T", "^I", "^L", "^M", "^N", "^#", "#A", "#C", "#E", "#I", "#N", "#O", "#T", "#U", "# ", "~A", "~E", "~I", "~U", "~$", " A", " B", " C", " D", " E", " F", " G", " H", " I", " J", " K", " L", " M", " N", " O", " P", " R", " S", " T", " U", " V", " W", " Z", " $", " ^", " #", " ~", " {", " \"", " (", " *", ". ", ", ", ": ", "; ", "? ", "! ", "{ ", "} ", "-A", "-I", "-L", "-M", "-O", "-S", "-U", "-#", "-~", "\" ", ") ", "* ", };
        String corpusPath="D:\\IN\\nco.txt";
        String markovPath="D:\\OUT\\markov1.txt";
        //String outFilePath="D:\\OUT\\markov1.txt";
        //String outFilePath="D:\\OUT\\markov1.txt";
        //String numeLant;
        for (int k=1;k<50;k++){
          //  numeLant"D:\\OUT\\teste-lant"+k+".txt";
            scrieMarkov(corpusPath,"D:\\OUT\\teste-lant"+k+".txt");

        }
//        scrieMarkov(corpusPath,outFilePath);

        String filename = markovPath;   //"D:\\OUT\\markov-22oct.txt";
        String str = readStringFromFile(markovPath);
        String corpusAsString = readStringFromFile(corpusPath);  //declar corpusul ca un  string pentru a putea folosi lungimea sau numarul de ocurente pentru diferite caractere
        String markovAsString = readStringFromFile(markovPath);  //declar lantul Markov ca un  string pentru a putea folosi lungimea sau numarul de ocurente pentru diferite caractere
        //System.out.print(str.length());
        int coloana3;//coloana 3 = numarul de aparitii al grupuui de caractere in lantul Markov
        double coloana4 = 0d; //coloana 3 imprtit la coloana 2
        double coloana5 = 0d; //zet alfa pe 2 inmultit cu radical din ((1-coloana4)/(coloana4 * coloana2))
        double coloana6 = 0d; //coloana4 * (1 - coloana5)
        double coloana7 = 0d; //coloana4 * (1 + coloana5)
        double coloana8 = 0d; //numarul de aparitii in corpusul ale literei reper supra lungimea totala a corpusului in caractere
        double coloana9 = 0d; //za2 inmultit cu radical din ((1 - coloana8)/(coloana8 inmultit cu lungimea corpusului/200))
        double coloana10 = 0d; //numar aparitii grup caractere in corpus supra lungime corpus
        double coloana11 = 0d; //za2 inmultit cu radical din ((1 - coloana10)/(coloana10 inmultit cu lungimea corpusului/200))
        double coloana12 = 0d; //coloana 10 supra coloana 8
        double coloana13 = 0d; //coloana 11 + coloana 9
        double coloana14 = 0d; //coloana 12 * (1 - coloana 13)
        double coloana15 = 0d; //coloana 12 * (1 + coloana 13)
        int lungimeCorpus = corpusAsString.length();

        for(int i=0;i<vector1.length;i++){
            int coloana2=aparitii(vector1[i],str); //coloana 2  numarul de aparitii al literei reper in lantul Markov
            int aparitiiReper=aparitii(vector1[i],corpusAsString);
            //System.out.println(aparitiiReper+"  "+lungimeCorpus);
            for(int j=0;j<vector2.length;j++){
                //System.out.println(i+" "+ j+ "=" + aparitii(vector1[i]+vector2[j],str));
               // System.out.print(i+" "+ j+ "=");
                coloana3 = aparitii(vector1[i]+vector2[j],str);
                if(coloana3>19){
                    coloana4 = (double)coloana3/coloana2;
                    System.out.print(vector1[i]+vector2[j]+"="+coloana2+"="+coloana3+"=");
                    System.out.printf("%.4f=", coloana4);
                    coloana5 = za2*Math.sqrt((1-coloana4)/(coloana4*coloana2));
                    System.out.printf("%.4f=", coloana5);
                    coloana6 = coloana4 * (1 - coloana5);
                    coloana7 = coloana4 * (1 + coloana5);
                    System.out.printf("%.4f = %.4f =", coloana6,coloana7);
                    coloana8 = (double)aparitiiReper/lungimeCorpus;
                    System.out.printf("%.4f=", coloana8);
                    coloana9 = za2 * Math.sqrt((1-coloana8) / (coloana8 * lungimeCorpus / 200));
                    System.out.printf("%.4f=", coloana9);
                    coloana10 = (double) aparitii(vector1[i]+vector2[j],corpusAsString)/lungimeCorpus;
                    System.out.printf("%.4f= ", coloana10);
                    coloana11 = za2 * Math.sqrt((1-coloana10) / (coloana10 * lungimeCorpus / 200));
                    System.out.printf("%.4f= ", coloana11);
                    coloana12 =  coloana10 / coloana8;
                    System.out.printf("%.4f= ", coloana12);
                    coloana13 =  coloana11 + coloana9;
                    System.out.printf("%.4f=", coloana13);
                    coloana14 = coloana12 * (1-coloana13);
                    System.out.printf("%.4f=", coloana14);
                    coloana15 = coloana12 * (1+coloana13);
                    System.out.printf("%.4f=", coloana15);


                    System.out.println();
                };

            }

        }


        //String str = "helloslkhellodjladfjhello";

      //  System.out.println(str);
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

    public static void eRP1P2(double n, double zAlfa, double pCaciula){
        double p1=0,p2=0,er;
        double test=0d;
//        test =n*pCaciula/(1-pCaciula);
  //      System.out.print(test+"     "+Math.sqrt(test));
        er=zAlfa*1/Math.sqrt(n*pCaciula/(1-pCaciula));
        System.out.print("p1="+p1 + "       p2=" +p2+ "        er="+ er);

    }

//    public static void p1P2();
    public static int aparitii(String subString, String bigString){
        String findStr = subString;
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = bigString.indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }

        //    System.out.println(subString + " = " + count);
        return count;
    }
    public static void scrieMarkov(String sIn, String sOut) throws IOException {
        int pas = 200;
        int pasCurent=0;
        int initialPozition = 30;
        char c;
        char cCurent;
        pasCurent = initialPozition;

        //System.out.println(s);
        //char[] test = s.toCharArray();
        String filename = sIn;//"D:\\IN\\corpus.txt";
        String content = new String(Files.readAllBytes(Paths.get(filename)), "UTF-8");
        c = content.charAt(initialPozition-1);
        //System.out.println(c + " " + initialPozition);
        //System.out.print(c);
        cCurent=c;
        insertCharInFile(c, sOut); //"D:\\OUT\\markov-22oct.txt"
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
                insertCharInFile(c, sOut);//"D:\\OUT\\markov-22oct.txt"
            }
        }
    }
    public static String readStringFromFile(String s) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(s)), "UTF-8");
        return content;
    }
    public static void insertStringInFile(String s, String fileNameIn){
        try
        {
            String filename= fileNameIn;
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(s+"");//appends the string to the file
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
            fw.write(s+"");//appends the string to the file
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


