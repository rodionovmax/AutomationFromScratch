package com.romanceabroad.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Helper {

    public static final String filePath = "/Users/rodionovmax/Documents/sandbox/Data.csv";
    private static final boolean brokenLastLineInFile = true;

    /** Method adds dashes to String for date conversion
     * Example: 19990202 -> 1999-02-02
     */
    public static String addDashes(String in){
        if (in.length() != 8){
            throw new RuntimeException("Input for date conversion doesn't consist of ..");
        }
        return in.substring(0,4) + "-" + in.substring(4,6) + "-" + in.substring(6,8);
    }

    public static void addDashes(ArrayList<String> in){
        for (int i = 0; i < in.size(); i++) {
            in.set(i, addDashes(in.get(i)));
        }
    }

    public static String fromTrueFalseToYN(String in){
        if (in.equals("t")){
            return "Y";
        }
        if (in.equals("f")){
            return "N";
        }
        throw new RuntimeException("TRUE/FALSE not found in " + in);
    }

    public static void fromTrueFalseToYN(ArrayList<String> in){
        for (int i = 0; i < in.size(); i++) {
            in.set(i, fromTrueFalseToYN(in.get(i)));
        }
    }

    /** Adds nulls on left side to string if string is less that 6 symbols
     * returns this string
     * @param input - input
     * @return
     */
    public static String get6String(String input){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6 - input.length(); i++) {
            sb.append("0");
        }
        sb.append(input);
        return sb.toString();
    }


    /** Collects all string from file, except first and last
     * returns ArrayList<String>
     * @return
     */
    public static ArrayList<String> getAllLinesFromFile(){
        ArrayList<String> fileData = new ArrayList<>(100);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String str;
            br.readLine();
            while ((str = br.readLine()) != null) {
                fileData.add(str);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        /* if (brokenLastLineInFile)
                fileData.remove(fileData.size() - 1); */
        return fileData;
    }

    /** Returns all string from file as HashMap, where account_number is being as key */
    public static HashMap<String, String> getAllLinesFromFileLinkedWithAccountNumber(){
        ArrayList<String> fileData = getAllLinesFromFile();
        HashMap<String, String> hm = new HashMap<>();
        for(String o : fileData){
            hm.put(o.substring(2-1, 17), o);
        }
        return hm;
    }

    /** Get from file just one column and returns as ArrayList<String>
     * @param startIndex - beginning of column
     * @param endIndex - end of column
     * @return
     */
    public static ArrayList<String> getColumnFromFile(int startIndex, int endIndex){
        ArrayList<String> dataFromFile = getAllLinesFromFile();
        ArrayList<String> outData = new ArrayList<>();
        for (String o : dataFromFile) {
            outData.add(o.substring(startIndex - 1, endIndex).trim());
        }
        return outData;
    }

    /** Counts how many times each word appears in ArrayList<String>
     * and returns result as HashMap<String, Integer>, where
     * K(Key) - word itself
     * V - number of times word appeared
     * @param input - input ArrayList<String>
     * @return
     */
    public static HashMap<String, Integer> calculateElementsCount(ArrayList<String> input){
        HashMap<String, Integer> out = new HashMap<>();
        for (String o : input){
            out.put(o, out.getOrDefault(o, 0) + 1);
        }
        return out;
    }

}
