import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Conditions {


    // Condition for Int
    int dice;

    @Test
    public void conditionForInt() {
        Random rand = new Random();
        dice = rand.nextInt(3);

        if (dice == 0) {
            System.out.println("You won a Ferrari!");
        } if (dice == 1) {
            System.out.println("You won a penthouse in New York!");
        } if (dice == 2) {
            System.out.println("You won a million dollars!");
        } if (dice == 3) {
            System.out.println("Sorry, you are loser");
        }
    }

    //Condition for boolean
    @Test
    public void conditionForBoolean() {
        boolean requirement = true;

        if (requirement) {
            System.out.println("Boolean is true!");
        } else {
            Assert.fail("Boolean is false");
        }
    }


    @Test
    public void test7() {
        List<String> crunchifyList1 = new ArrayList<>(Arrays.asList("kiwi", "orange", "melon"));
        // Method 1
//        String element = crunchifyList1.get(0);
//        System.out.println(element);

        // Method 2
        if (crunchifyList1.contains("orange")) {
            System.out.println(crunchifyList1);
        }
    }

    @Test
    public void test8() {
        List<Integer> crunchifyList1 = new ArrayList<>(Arrays.asList(5, 10, 19));
        int sum = crunchifyList1.get(1) + crunchifyList1.get(2);
        System.out.println(sum);
    }

    @Test
    public void test9() {
        List<Integer> crunchifyList1 = new ArrayList<>(Arrays.asList(5, 10, 19));
        System.out.println(crunchifyList1.size());
        crunchifyList1.add(10);
        System.out.println(crunchifyList1.size());
        for (int i = 0; i < crunchifyList1.size(); i++) {
            int element = crunchifyList1.get(i);
            System.out.println(element);
        }
    }

    @Test
    public void test10() {

        String phrase = "Melon inside list";
        List<String> crunchifyList1 = new ArrayList<>(Arrays.asList("apple", "kiwi", phrase));

        crunchifyList1.add("Melon");
        System.out.println(crunchifyList1);
        System.out.println(crunchifyList1.size());

        for (int i = 0; i < crunchifyList1.size(); i++) {
            String element = crunchifyList1.get(i);
            System.out.println(i + " iteration");

            if (element.contains("Me")) {
                System.out.println(phrase);
                continue;
            }
            if (element.equals("orange")){
                System.out.println("Orange");
            }
            if (element.contains("i")){
                System.out.println("IIIIIII");
            } else {
                System.out.println("Bad loop");
            }
        }
    }

    @Test
    public void intArrayList(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        numbers.add(7);
        numbers.add(129534);
        System.out.println("Look, here is a list: " + numbers);
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            System.out.println("I'm printing number: " + num);
        }
    }


    @Test
    public void newKingOfWesterosBettingGame(){

        String randomFamily;

        List<String> gameOfThronesFamilies = new ArrayList<>(Arrays.asList("Lannister", "Stark", "Targaryen"));
        // Add 2 families to the list
        Collections.addAll(gameOfThronesFamilies, "Baratheon", "Tyrell");
        System.out.println("Here is our finalists: " + gameOfThronesFamilies);

        for (int i = 0; i < gameOfThronesFamilies.size(); i++) {

            // Get random item from the list
            randomFamily = gameOfThronesFamilies.get(new Random().nextInt(gameOfThronesFamilies.size()));
            System.out.println(randomFamily);

            // condition
            if (randomFamily == "Lannister"){
                System.out.println("Cersei is a new queen of Westeros");
                continue;
            }
            if (randomFamily == "Stark"){
                System.out.println("Sansa is a new queen of Westeros");
                continue;
            }
            if (randomFamily == "Targaryen"){
                System.out.println("Daenerys is a new queen of Westeros");
                continue;
            }
            if (randomFamily == "Baratheon"){
                System.out.println("Oooops nobody is alive... No king");
                continue;
            }
            if (randomFamily == "Tyrell"){
                System.out.println("Everyone is dead -> Night King is a new king of Westeros");
                continue;
            }
            else {
                Assert.fail("Ooops code 404 something was wrong");
            }
        }

    }







}