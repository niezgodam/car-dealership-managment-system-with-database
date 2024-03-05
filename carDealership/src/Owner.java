import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Owner extends Person{

    private static int account_balance;
    private static boolean hire_employee;
    private static Connection connection;
    private static final long numberOfLoadings = 1923601263L;
    /*
      Here are the values extracted 
      using the getenv method, 
      which collects information 
      from the hidden .env file
    */
    static String owner_table = getenv("OWNER_TABLE");
    static String user = getenv("USER");
    static String password = getenv("PASSWORD");
    static String schema_name = getenv("SCHEMA_NAME");

    public static int getAccountBalance() {
        return account_balance;
    }

    public static void setAccountBalance(int balance) {
        account_balance = balance;
    }

    public static boolean isHireEmployee() {
        return hire_employee;
    }

    public static void setHireEmployee(boolean hire) {
        hire_employee = hire;
    }

    public static String getenv(String env){
        Properties properties = new Properties();
        FileInputStream input = null;
        try{
            input = new FileInputStream(".env"); //name of file 
            properties.load(input);
        }catch (IOException ex) {
            ex.printStackTrace();
        }

        return properties.getProperty(env);
    }

    Owner(String first_name,String second_name, int age){
        super(first_name, second_name,age);
    }

    public static int moneyFromDataBase(Connection connection) throws SQLException {
        int money = 0;
        String sqlQuery = String.format("SELECT money FROM %s",owner_table);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    money = resultSet.getInt("money");
                } else {
                    System.err.println("Something went wrong, can't read data.");
                }
            }
        }
        return money;
    }


    public static void main(String[] args) throws Exception {
        try {
            connection = DriverManager.getConnection(
                    String.format("jdbc:mysql://localhost:3306/%s",schema_name),
                    user,password);
            account_balance = moneyFromDataBase(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean continueloop = true;
        for(int i=0;i<numberOfLoadings && continueloop;i++){
            switch(activityChoice()){
            case "1": 
                System.out.println("You account balance: "+account_balance);
                break;
            case "2":   
                CarsToBuy.main(args);
                break;
            case "3":   
                CarsToBuy.displayOwnerCars(CarsToBuy.getOwnerCar());
                break;
            case "4":   
                hire_employee = true;
                EmployeeManagment.main(args);
                break;
            case "5":   
                hire_employee = false;
                EmployeeManagment.main(args);
                break;
            case "6": 
                System.exit(1);
                break;
            default: 
                System.out.println("Something went wrong");
            }
        }

    }

    static String activityChoice() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. Check account balance");
        System.out.println("2. Buy new cars");
        System.out.println("3. Display owner cars");
        System.out.println("4. Hire employee");
        System.out.println("5. Dismiss employee");
        System.out.println("6. Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
