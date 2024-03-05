import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;
import java.sql.SQLException;

public class Buyer {

    
    private static Connection connection;
    private static int account_balance;
    private static final long numberOfLoadings = 1923601263L;
    /*
      Here are the values extracted 
      using the getenv function, 
      which collects information 
      from the hidden .env file
    */
    static String buyer_table = getenv("BUYER_TABLE");
    static String user = getenv("USER");
    static String password = getenv("PASSWORD");
    static String schema_name = getenv("SCHEMA_NAME");

    //function to read hidden values from file .env
    public static String getenv(String env){
        Properties properties = new Properties();
        FileInputStream input = null;
        try{
            input = new FileInputStream(".env");
            properties.load(input);
        }catch (IOException ex) {
            ex.printStackTrace();
        }

        return properties.getProperty(env);
    }

    //getter i setter of accountBalance
    public static int getAccountBalance() {
        return account_balance;
    }

    public static void setAccountBalance(int balance) {
        account_balance = balance;
    }

    //this function read data(money) from DataBase
    public static int moneyFromDataBase(Connection connection) throws SQLException {
        int money = 0;
        String sqlQuery = String.format("SELECT money FROM %s", buyer_table);
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
                CarsForBuyer.main(args);
                break;
            case "3":   
                CarsForBuyer.displayBuyerCars(CarsForBuyer.getBuyerCar());
                break;
            case "4": 
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
        System.out.println("3. Display cars");
        System.out.println("4. Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}



