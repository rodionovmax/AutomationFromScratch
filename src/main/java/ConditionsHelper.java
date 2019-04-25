import java.util.Scanner;

public class ConditionsHelper {

    String inputString;


//    public String getInput() {
//
//        System.out.println("Let's play a game. Choose 'money' or 'prise' and type it: ");
//        Scanner scanner = new Scanner(System.in);
//        inputString = scanner.nextLine();
//        System.out.println( "String read from console is : \n" + inputString);
//        return inputString;
//    }

    private final Scanner scanner;

    public ConditionsHelper(){
        this(new Scanner(System.in));
    }

    ConditionsHelper(Scanner scanner){
        this.scanner = scanner;
    }

    public String getInput() {
        inputString = scanner.nextLine();
        System.out.println( "String read from console is : \n" + inputString);
        return inputString;
    }
}
