package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FileTest {

    enum Checks{
        REQUIRED,
        OPTIONAL,
        RESTRICTED
    }

    @DataProvider(name = "linesFromFile")
    public Object[][] getDataFromDataprover(){
        Object[][] objects = null;
        ArrayList<String> als = Helper.getAllLinesFromFile();
        objects = new Object[als.size()][2];
        for (int i = 0; i < als.size(); i++) {
            objects[i][0] = i;
            objects[i][1] = als.get(i);
        }
        return objects;
    }

    @Test(dataProvider = "linesFromFile")
    public void testARN(int line, String input){
        final int ARN_COLUMN_START = 2;
        final int ARN_COLUMN_END = 10;
        if(!checkLine(input, ARN_COLUMN_START, ARN_COLUMN_END, Checks.REQUIRED, Checks.RESTRICTED, Checks.OPTIONAL, Checks.RESTRICTED))
            Assert.fail("Error in ARN number " + line + ": " + input);
    }

    @Test(dataProvider = "linesFromFile")
    public void testLastName(int line, String input){
        final int LastName_COLUMN_START = 11;
        final int LastName_COLUMN_END = 20;
        if(!checkLine(input, LastName_COLUMN_START, LastName_COLUMN_END, Checks.RESTRICTED, Checks.REQUIRED, Checks.OPTIONAL, Checks.RESTRICTED))
            Assert.fail("Error in LastName " + line + ": " + input);
    }

    @Test(dataProvider = "linesFromFile")
    public void testFirstName(int line, String input){
        final int FirstName_COLUMN_START = 21;
        final int FirstName_COLUMN_END = 30;
        if(!checkLine(input, FirstName_COLUMN_START, FirstName_COLUMN_END, Checks.REQUIRED, Checks.REQUIRED, Checks.OPTIONAL, Checks.RESTRICTED))
            Assert.fail("Error in FirstName " + line + ": " + input);
    }

    @Test(dataProvider = "linesFromFile")
    public void testAddress(int line, String input){
        final int Address_COLUMN_START = 31;
        final int Address_COLUMN_END = 40;
        if(!checkLine(input, Address_COLUMN_START, Address_COLUMN_END, Checks.REQUIRED, Checks.REQUIRED, Checks.OPTIONAL, Checks.RESTRICTED))
            Assert.fail("Error in Address 1 " + line + ": " + input);
    }

    @Test(dataProvider = "linesFromFile")
    public void testAddressNumbers(int line, String input){
        final int Address_COLUMN_START = 31;
        final int Address_COLUMN_END = 40;
        if(!checkLetterDigitalSequenceInLine(input, Address_COLUMN_START, Address_COLUMN_END, 6))
            Assert.fail("Error in Address 1 " + line + ": " + input);
    }

    public static boolean checkLetterDigitalSequenceInLine(String input, int startIndex, int endIndex, int requiredCount){
        int count = 0;
        for (int i = startIndex - 1; i < endIndex; i++) {
            if (Character.isDigit(input.charAt(i)) || Character.isLetter(input.charAt(i)))
                count++;
        }
        return count == requiredCount;
    }

    /**
     * @param input
     * @param startIndex - index of the row where check starts
     * @param endIndex - index of the row where check ends
     * @param digits - rule to check do digits exist
     * @param letters - rule to check do letters exist
     * @param spaces - rule to check do spaces exist
     * @param specChars - rule to check special symbols
     * @return
     */

    public static boolean checkLine(String input, int startIndex, int endIndex, Checks digits, Checks letters, Checks spaces, Checks specChars){
        final String specialChars = "/!#$%^&*()\"{}_[]|\\?/<>,.";
        boolean digitsPresent = false;
        boolean spacesPresent = false;
        boolean lettersPresent = false;
        boolean specCharsPresent = false;
        for (int i = startIndex - 1; i < endIndex; i++) {
            if (Character.isDigit(input.charAt(i))) digitsPresent = true;
            if (Character.isLetter(input.charAt(i))) lettersPresent = true;
            if (input.charAt(i) == ' ') spacesPresent = true;
            if (specialChars.contains(input.substring(i, i + 1))) specCharsPresent = true;
        }
        if (digits == Checks.REQUIRED && !digitsPresent) return false;
        if (digits == Checks.RESTRICTED && digitsPresent) return false;
        if (letters == Checks.REQUIRED && !lettersPresent) return false;
        if (letters == Checks.RESTRICTED && lettersPresent) return false;
        if (spaces == Checks.REQUIRED && !spacesPresent) return false;
        if (spaces == Checks.RESTRICTED && spacesPresent) return false;
        if (specChars == Checks.REQUIRED && !specCharsPresent) return false;
        if (specChars == Checks.RESTRICTED && specCharsPresent) return false;
        return true;
    }

    /*
    public static boolean checkLinkedLine(String input, int startIndex1, int endIndex1, int startIndex2, int endIndex2, int startIndex3, int endIndex3){
        String text1 = input.substring(startIndex1, endIndex1);
        String text2 = input.substring(startIndex2, endIndex2);
        String text3 = input.substring(startIndex3, endIndex3);
        if (text1.contains(cWord1)){
            if (!text2.contains(cWord2) || !text3.contains(cWord3)) return false;
        }
        return true;
    }
     */
}
