package com.romanceabroad.ui;

import org.testng.annotations.DataProvider;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataProviders {


    // com.romanceabroad.ui.Data Provider for searchTabTest in Search test class
    @DataProvider(name = "ValueOfDropDownList")
    public static Object[][] checkAllCountries(){
        return new Object[][]{

                {"20", "44", "views_count ", true},
                {"33", "50", "date_created", false},
                {"44", "55", "name", false},
        };
    }


    @DataProvider(name = "Registration")
    public static Object[][] checkRegistration() {
        return new Object[][]{
                {Data.email1, Data.password, "Matt_Damon", "20", "May", "2000", "1234567890", "New York"},
                {Data.email2, "Pass!222", "Harry", "25", "Nov", "1990", "345687923412", "Chicago"},
                {Data.email3, "P@@$$w00r%", "James", "31", "Dec", "1955", "1323434534", "Norilsk"},
        };
    }


    // com.romanceabroad.ui.Data Provider with csv file for com.romanceabroad.ui.Data Driven Testing
    @DataProvider(name = "Registration2")
    public static Object[][] testRegistration2() throws Exception{
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("Registration.csv")).stream().forEach(s-> {

            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});

        });

        return out.toArray(new Object[out.size()][]);
    }


    // com.romanceabroad.ui.Data Provider for testing passwords
    @DataProvider(name = "passwords")
    public static Object[][] testPasswords() {
        return new Object[][]{
                {"baby.hacker@mail.com", "Password1", true},
                {"paveldurov@yandex.ru", "GD%^73rj", true},
                {"go.bruins@hotmail.com", MainPage.generateRandomString(), true},
                {MainPage.generateRandomString(), "2485249##!", true},
                {"king_of_apes@gmail.com", "b@n@n@", true},
        };
    }


    // com.romanceabroad.ui.Data Provider for searchGiftsTest
    @DataProvider(name = "gifts")
    public static Object[][] testGifts(){
        return new Object[][]{
                {Data.searchGift1,true},
                {Data.searchGift2,false},
                {Data.searchGift3,true},
                {Data.searchGift4,false},
                {Data.searchGift5,true},
                {Data.searchGift6,false},
                {Data.searchGift7,true},
                {Data.searchGift8,false},
                {Data.searchGift9,true},
                {Data.searchGift10,true},
                {Data.searchGift11,false},
        };
    }

    @DataProvider(name = "gifts2")
    public static Object[][] testGiftsWithCsv() throws Exception{
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("SearchGifts.csv")).stream().forEach(s-> {

            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1]});

        });

        return out.toArray(new Object[out.size()][]);
    }


    @DataProvider(name = "gifts3")
    public static Object[][] testGiftsInLoop(){
        return new Object[][]{
                {Data.searchGift1,true,1},
                {Data.searchGift2,false,2},
                {Data.searchGift3,true,3},
                {Data.searchGift4,false,4},
                {Data.searchGift5,true,5},
                {Data.searchGift6,false,6},
                {Data.searchGift7,true,7},
                {Data.searchGift8,false,8},
                {Data.searchGift9,true,9},
                {Data.searchGift10,true,10},
                {Data.searchGift11,false,11},
        };
    }
}
