import java.util.ArrayList;
import java.util.Scanner;


public class Transaction {
    ArrayList<Car> carsSelected = new ArrayList<>();

    //method that meets the requirements for cars
    public static void processCarRequirements(Car[] carsForBuyer, ArrayList<Car> carsSelected, ArrayList<Car> pom, int currentBalance) {
        Scanner scanner = new Scanner(System.in);
        boolean continueSelecting = true;

        while (continueSelecting) {
            String carRequirementsChoice = Transaction.getCarRequirementsChoice();

            switch (carRequirementsChoice) {
                case "1":
                    Transaction.markChoice(carsForBuyer, carsSelected, pom);
                    break;
                case "2":
                    Transaction.year(carsForBuyer, carsSelected, pom);
                    break;
                case "3":
                    Transaction.horsepower(carsForBuyer, carsSelected, pom);
                    break;
                case "4":
                    Transaction.colorChoice(carsForBuyer, carsSelected, pom);
                    break;
                case "5":
                    Transaction.price(carsForBuyer, carsSelected, pom);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            
            if(!carsSelected.isEmpty()){
                System.out.println("Cars with criteria close to expectations: ");
                for(Car car: carsSelected){
                    System.out.println(car);
                }
            }else{
                System.out.println("No cars meet your criteria.");
            }

            System.out.println("Do you want to add more conditions? (yes/no)");
            String continueChoice = scanner.nextLine().toLowerCase();
            if (!continueChoice.equals("yes")) {
                continueSelecting = false;
            }
        }
    }

    public static String askAboutRequirements() {
        System.out.println("Do you want to make other conditions? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String finalTransaction() {
        System.out.println("What you want to do?");
        System.out.println("1. Buy a car\n2. Resign");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String finalBuy(ArrayList<Car> carsSelected) {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getCarRequirementsChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. What brand do you propose? 2. Year of production 3. How many horsepower 4. Color 5. Price");
        System.out.println("Enter your car requirements choice:");
        return scanner.nextLine();
    }

    /*
        Here are the methods
        about requirements of 
        mark,year,choice,color,price.
    */

    public static void markChoice(Car[] carsForBuyer, ArrayList<Car> carsSelected, ArrayList<Car> pom) {
        System.out.println("");
        System.out.println("Enter a name of mark: ");
        Scanner scanner = new Scanner(System.in);
        String markChoice = scanner.nextLine();

        if (carsSelected.size() == 0) {
            for (Car car : carsForBuyer) {
                if (car.getMark().equalsIgnoreCase(markChoice)) {
                    carsSelected.add(car);
                }
            }
        } else {
            for (Car car : carsSelected) {
                if (car.getMark().equalsIgnoreCase(markChoice)) {
                    if(!pom.contains(car)){
                        pom.add(car); 
                    }
                }else{
                    pom.remove(car);
                }
            }
            carsSelected.clear();
            carsSelected.addAll(pom);
        }
    }

    public static void year(Car[] carsForBuyer, ArrayList<Car> carsSelected, ArrayList<Car> pom) {
        System.out.println("");
        System.out.println("Enter a year of production: ");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        if (carsSelected.size() == 0) {
            for (Car car : carsForBuyer) {
                if (car.getYear() >= year - 1 && car.getYear() <= year + 1) {
                    carsSelected.add(car);
                }
            }
        } else {
            for (Car car : carsSelected) {
                if (car.getYear() >= year - 1 && car.getYear() <= year + 1) {
                    if(!pom.contains(car)){
                        pom.add(car); 
                    }
                }else{
                    pom.remove(car);
                }
            }
            carsSelected.clear();
            carsSelected.addAll(pom);
        }
    }

    public static void horsepower(Car[] carsForBuyer, ArrayList<Car> carsSelected, ArrayList<Car> pom) {
        System.out.println("");
        System.out.println("Enter a number of horsepower: ");
        Scanner scanner = new Scanner(System.in);
        int horsepower = scanner.nextInt();

        if (carsSelected.size() == 0) {
            for (Car car : carsForBuyer) {
                if (car.getHorsepower() >= horsepower - 30 && car.getHorsepower() <= horsepower + 30) {
                    carsSelected.add(car);
                }
            }
        } else {
            for (Car car : carsSelected) {
                if (car.getHorsepower() >= horsepower - 30 && car.getHorsepower() <= horsepower + 30) {
                    if(!pom.contains(car)){
                        pom.add(car); 
                    }
                }else{
                    pom.remove(car);
                }
            }
            carsSelected.clear();
            carsSelected.addAll(pom);
        }
    }

    public static void colorChoice(Car[] carsForBuyer, ArrayList<Car> carsSelected, ArrayList<Car> pom) {
        System.out.println("");
        System.out.println("Enter a name of color: ");
        Scanner scanner = new Scanner(System.in);
        String colorChoice = scanner.nextLine();

        if (carsSelected.size() == 0) {
            for (Car car : carsForBuyer) {
                if (car.getColor().equalsIgnoreCase(colorChoice)) {
                    carsSelected.add(car);
                }
            }
        } else {
            for (Car car : carsSelected) {
                if (car.getColor().equalsIgnoreCase(colorChoice)) {
                    if(!pom.contains(car)){
                        pom.add(car); 
                    }
                }else{
                    pom.remove(car);
                }
            }
            carsSelected.clear();
            carsSelected.addAll(pom);
        }
    }

    public static void price(Car[] carsForBuyer, ArrayList<Car> carsSelected, ArrayList<Car> pom) {
        System.out.println("");
        System.out.println("Enter a number of price: ");
        Scanner scanner = new Scanner(System.in);
        int price = scanner.nextInt();

        if (carsSelected.size() == 0) {
            for (Car car : carsForBuyer) {
                if (car.getPrice() >= price - 5000 && car.getPrice() <= price + 5000) {
                    carsSelected.add(car);
                }
            }
        } else {
            for (Car car : carsSelected) {
                if (car.getPrice() >= price - 5000 && car.getPrice() <= price + 5000) {
                    if(!pom.contains(car)){
                        pom.add(car); 
                    }
                }else{
                    pom.remove(car);
                }
            }
            carsSelected.clear();
            carsSelected.addAll(pom);
        }
    }
}
