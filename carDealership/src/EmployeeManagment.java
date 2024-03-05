import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;


public class EmployeeManagment{

    private static Connection connection;
    private static ArrayList<Employee> employees;
    private ArrayList<Employee> unemployed;
    static String user = getenv("USER");
    static String password = getenv("PASSWORD");
    static String schema_name = getenv("SCHEMA_NAME");
    static String employees_table = getenv("EMPLOYEES_TABLE");
    static String unemployed_table = getenv("UNEMPLOYED_TABLE");

    public EmployeeManagment(){
        employees = new ArrayList<>();
        unemployed = new ArrayList<>();
    }

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
        EmployeeManagment employeeManagement = new EmployeeManagment();
        Scanner scanner = new Scanner(System.in);

        employeeManagement.getEmployeesFromDatabase();
        employeeManagement.getUnemployedFromDatabase();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Display Employees");
            System.out.println("2. Display Unemployed");
            System.out.println("3. Hire Employee");
            System.out.println("4. Dismiss Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    employeeManagement.displayEmployees();
                    break;
                case 2:
                    employeeManagement.displayUnemployed();
                    break;
                case 3:
                    System.out.println("Select an employee to hire:");
                    employeeManagement.displayUnemployed();
                    employeeManagement.employeeChoice("true");
                    break;
                case 4:
                    System.out.println("Select an employee to dismiss:");
                    employeeManagement.displayEmployees();
                    employeeManagement.employeeChoice("false");
                    break;
                case 5:
                    exit = true;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }

    public void getEmployeesFromDatabase(){
        try{
            connection = DriverManager.getConnection(
                String.format("jdbc:mysql://localhost:3306/%s",schema_name),
                user,password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s", employees_table));

            while(resultSet.next()){
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                int experience = resultSet.getInt("experience");
                String position = resultSet.getString("position");
                Employee employee = new Employee(firstName, lastName, age, experience, position);
                employees.add(employee);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e){
            System.out.println("Error while fetching employees from database: " + e.getMessage());
        }
    }


    public void addEmployeeToDatabase(Employee employee){

        try{
            connection = DriverManager.getConnection(
                    String.format("jdbc:mysql://localhost:3306/%s",schema_name),
                    user,password);

            Statement statement = connection.createStatement();
            String query = String.format(String.format("INSERT INTO %s (first_name, last_name, age, experience, position) VALUES ('%s', '%s', %d, %d, '%s')",employees_table),
                                         employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getExperience(), employee.getPosition());
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (Exception e){
            System.out.println("Error while adding employee to database: " + e.getMessage());
        }

    }

    public void removeEmployeeFromDatabase(Employee employee){

        try{
            connection = DriverManager.getConnection(
                    String.format("jdbc:mysql://localhost:3306/%s",schema_name),
                    user,password);

            String unemployed_table = getenv("UNEMPLOYED_TABLE");
            Statement statement = connection.createStatement();

            String query = String.format(String.format("DELETE FROM %s WHERE first_name = '%s' AND last_name = '%s' AND age = %d AND experience = %d AND position = '%s'",unemployed_table),
            employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getExperience(), employee.getPosition());
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (Exception e){
            System.out.println("Error while removing employee to database: " + e.getMessage());
        }

    }


    public void getUnemployedFromDatabase(){
        try{
            connection = DriverManager.getConnection(
                    String.format("jdbc:mysql://localhost:3306/%s",schema_name),
                    user,password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s",unemployed_table));

            while(resultSet.next()){
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                int experience = resultSet.getInt("experience");
                String position = resultSet.getString("position");
                Employee employee = new Employee(firstName, lastName, age, experience, position);
                unemployed.add(employee);
            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e){
            System.out.println("Error while fetching employees from database: " + e.getMessage());
        }
    }


    public void addUnemployedToDatabase(Employee employee){

        try{
            connection = DriverManager.getConnection(
                    String.format("jdbc:mysql://localhost:3306/%s",schema_name),
                    user,password);
                
            Statement statement = connection.createStatement();
            String query = String.format(String.format("INSERT INTO %s (first_name, last_name, age, experience, position) VALUES ('%s', '%s', %d, %d, 'recruiter')",unemployed_table),
                                         employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getExperience());
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (Exception e){
            System.out.println("Error while adding employee to database: " + e.getMessage());
        }

    }

    public void removeUnemployedFromDatabase(Employee employee){

        try{
            String user = getenv("USER");
            String password = getenv("PASSWORD");
            String schema_name = getenv("SCHEMA_NAME");
            Connection connection = DriverManager.getConnection(
                    String.format("jdbc:mysql://localhost:3306/%s",schema_name),
                    user,password);

            String unemployed_table = getenv("UNEMPLOYED_TABLE");
            Statement statement = connection.createStatement();

            String query = String.format(String.format("DELETE FROM %s WHERE first_name = '%s' AND last_name = '%s' AND age = %d AND experience = %d AND position = '%s'",unemployed_table),
            employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getExperience(), employee.getPosition());

            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (Exception e){
            System.out.println("Error while removing employee to database: " + e.getMessage());
        }

    }

    public void displayEmployees(){
        System.out.println("Employees: ");
        for(int i=0; i < employees.size();i++){
            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }

    public void displayUnemployed() {
        System.out.println("Unemployed:");
        for(int i=0; i < unemployed.size();i++){
            System.out.println((i + 1) + ". " + unemployed.get(i));
        }
    }

    public void hireEmployee(Employee employee){
        unemployed.remove(employee);
        removeUnemployedFromDatabase(employee);
        addEmployeeToDatabase(employee);
        employees.add(employee);
    }

    public void dismissEmployee(Employee employee){
        unemployed.add(employee);
        removeEmployeeFromDatabase(employee);
        addUnemployedToDatabase(employee);
        employees.remove(employee);
    }

    public void employeeChoice(String hireStatus) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> selectedList = (hireStatus.equals("true")) ? unemployed : employees;
        System.out.print("Choose the number between 1-" + selectedList.size() + ": ");
        int choice = scanner.nextInt();
        Employee selectedEmployee = selectedList.get(choice - 1);
        if (hireStatus.equals("true")) {
            hireEmployee(selectedEmployee);
        } else {
            dismissEmployee(selectedEmployee);
        }
    }
    
}





