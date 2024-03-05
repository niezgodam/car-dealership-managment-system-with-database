import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class CarsToBuy {

    private static Connection connection;
    /*
      Here are the values extracted 
      using the getenv method, 
      which collects information 
      from the hidden .env file
    */
    static String user = getenv("USER");
    static String password = getenv("PASSWORD");
    static String schema_name = getenv("SCHEMA_NAME");
    static String owner_table = getenv("OWNER_TABLE");
    static String owner_cars = getenv("OWNER_CARS");
    static String car_to_buy = getenv("CARS_TO_BUY");

    //method to read hidden values from file .env
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

    public static void main(String[] args) {
        try {
            ArrayList<Car> carsSelected = new ArrayList<>();
            ArrayList<Car> pom = new ArrayList<>();

            //connecting to data base
            connection = DriverManager.getConnection(
                    String.format("jdbc:mysql://localhost:3306/%s",schema_name),
                    user,password);

            //assigning balance to money from database
            int currentBalance = moneyFromDataBase(connection);

            //getting cars from database
            Car[] carsToBuy = getCarsFromDatabase();

            //calling a method that meets the requirements for cars
            Transaction.processCarRequirements(carsToBuy, carsSelected, pom, currentBalance);

            //displaying selected cars
            for (Car car : carsSelected) {
                System.out.println(car);
            }

            //choice if we want to buy or resign
            if (!carsSelected.isEmpty()) {
                String buyDecision = Transaction.finalTransaction();
                if (buyDecision.equals("1")) {
                    buyCar(carsSelected);
                } else {
                    System.out.println("You chose to resign from buying.");
                }
            } else {
                System.out.println("No cars match your criteria.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     Method to buy a car
     Including adding and deleting 
     using database
     */
    public static void buyCar(ArrayList<Car> carsSelected) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the car you want to buy by entering its index:");
            for (int i = 0; i < carsSelected.size(); i++) {
                System.out.println((i + 1) + ". " + carsSelected.get(i));
            }
            int selectedIndex = scanner.nextInt();
            Car selectedCar = carsSelected.get(selectedIndex - 1);

            int currentMoney = moneyFromDataBase(connection);
            int newMoney = currentMoney - selectedCar.getPrice();
            if(currentMoney < selectedCar.getPrice()){
                System.out.println("Not enough money");
            }else{
                updateMoneyInDataBase(connection, newMoney);
                PreparedStatement preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s (mark, model, year, horsepower, color, price) VALUES (?, ?, ?, ?, ?, ?)",owner_cars));
                preparedStatement.setString(1, selectedCar.getMark());
                preparedStatement.setString(2, selectedCar.getModel());
                preparedStatement.setInt(3, selectedCar.getYear());
                preparedStatement.setInt(4, selectedCar.getHorsepower());
                preparedStatement.setString(5, selectedCar.getColor());
                preparedStatement.setInt(6, selectedCar.getPrice());
                preparedStatement.executeUpdate();
                System.out.println("Congratulations! You have bought the car: " + selectedCar);

                Statement statement = connection.createStatement();
                String query = String.format("DELETE FROM %s WHERE mark = '%s' AND model = '%s' AND year = %d AND horsepower = %d AND color = '%s' AND price = %d",
                car_to_buy,selectedCar.getMark(), selectedCar.getModel(), selectedCar.getYear(), selectedCar.getHorsepower(),selectedCar.getColor(),selectedCar.getPrice());
                statement.executeUpdate(query);
                statement.close();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method to display all buyer cars
    public static void displayOwnerCars(Car[] ownerCars) {
        System.out.println("Owner cars: ");
        for (Car car : ownerCars) {
            System.out.println(car);
        }
    }

    /*
        Money from database
    */

    //taking money value from the database
    public static int moneyFromDataBase(Connection connection) throws SQLException{
        int money = 0;
        String sqlQuery = String.format("SELECT money FROM %s", owner_table);
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    money = resultSet.getInt("money");
                }
            }
        }
        return money;
    }

    //update money value to database
    public static void updateMoneyInDataBase(Connection connection, int newMoney) throws SQLException {
        String sqlQuery = String.format("UPDATE %s SET money = ?", owner_table);

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, newMoney);
            preparedStatement.executeUpdate();
        }
    }

    /*
        Cars from database
    */

    //method to get cars from database(table for buyer)
    public static Car[] getCarsFromDatabase() {
        Car[] carsToBuy = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s", car_to_buy));
            ArrayList<Car> carList = new ArrayList<>();

            while (resultSet.next()) {
                String mark = resultSet.getString("mark");
                String model = resultSet.getString("model");
                int year = resultSet.getInt("year");
                int horsepower = resultSet.getInt("horsepower");
                String color = resultSet.getString("color");
                int price = resultSet.getInt("price");

                Car car = new Car(mark, model, year, horsepower, color, price);
                carList.add(car);
            }

            carsToBuy = carList.toArray(new Car[0]);

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carsToBuy;
    }

    //method to check current owner cars(from database)
    public static Car[] getOwnerCar() {
        Car[] ownercars = null;
        try {
            connection = DriverManager.getConnection(
                    String.format("jdbc:mysql://localhost:3306/%s",schema_name),
                    user,password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s", owner_cars));

            ArrayList<Car> ownerCarList = new ArrayList<>();

            while (resultSet.next()) {
                String mark = resultSet.getString("mark");
                String model = resultSet.getString("model");
                int year = resultSet.getInt("year");
                int horsepower = resultSet.getInt("horsepower");
                String color = resultSet.getString("color");
                int price = resultSet.getInt("price");

                Car car = new Car(mark, model, year, horsepower, color, price);
                ownerCarList.add(car);
            }

            ownercars = ownerCarList.toArray(new Car[0]);

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ownercars;
    }

}
