import java.util.Scanner;


public class App{
    public static void main(String[] args) throws Exception {

        //overall menu
        menuDisplay();
        switch(choice()){
            case "1":
            break;
            case "2": System.exit(0);
            break;
            default: System.out.println("Something went wrong");
        }
        //person choose menu
        switch(personChoice()){
            case "1": System.out.println("You started as a buyer");
            Buyer.main(args);
            break;
            case "2": System.out.println("You started as a owner");
            Owner.main(args);
            break;
            default: System.out.println("Something went wrong");
        }


    }

    static void menuDisplay(){ 
        System.out.println("1. Choose person\n2.Exit");

    }

    //scanner getting information of choice
    static String choice(){
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        return choice;
    }

    static String personChoice(){
        System.out.println("");
        System.out.println("1. Buyer\n2. Owner\n");
        Scanner scanner = new Scanner(System.in);
        String character_choice = scanner.next();
        return character_choice;
    }

}

