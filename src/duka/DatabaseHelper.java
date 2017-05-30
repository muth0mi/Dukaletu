package duka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DatabaseHelper {

    private static final String url = "jdbc:mysql://localhost:3306/duka";
    private static final String username = "root";  // mysql username
    private static final String password = "ericco//23";  // mysql password
    private Connection mConnection = null;
    private PreparedStatement preparedStatement;

    public void createTables() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            mConnection = DriverManager.getConnection(url, username, password);

            if (mConnection == null) {
                System.out.println("Connection not successful");
                return;
            }

            System.out.println("Connection is successful");

            // changed 'type' to 'usertype' because type is a java keyword
            String query = "CREATE TABLE IF NOT EXISTS users (id INT (3) AUTO_INCREMENT, email VARCHAR (32) PRIMARY KEY , password VARCHAR (32), usertype VARCHAR (5) )";

            preparedStatement = mConnection.prepareStatement(query);
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            System.out.println("Unable to connect to db and create tables");
        }

    }


    // Adding new User
    public void addUser(User user) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            mConnection = DriverManager.getConnection(url, username, password);

            if (mConnection == null) {
                System.out.println("Connection not successful");
            }

            System.out.println("Connection is successful");
            String insertQuery = String.format("INSERT INTO users VALUES ( '%d' , '%s' , '%s' , '%s' ) ", user.getId(), user.getEmail(), user.getPassword(), user.getmUserType());

            System.out.println(insertQuery);

            preparedStatement = mConnection.prepareStatement(insertQuery);
            preparedStatement.executeUpdate();
            System.out.println("values inserted successfully");


        } catch (Exception e) {
            System.out.println("Connection failed");
        }


    }

    // Getting a user
    public User getUser(String email) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            mConnection = DriverManager.getConnection(url, username, password);

            if (mConnection == null) {
                System.out.println("Connection not successful");
            }

            System.out.println("Connection is successful");

            PreparedStatement ps = mConnection.prepareStatement("SELECT * FROM users WHERE email = '" + email + "' ");
            ps.executeQuery();

            ResultSet result = ps.getResultSet();
            if (result.next()) {
                int _id = result.getInt(1);
                String _email = result.getString(2);
                String _password = result.getString(3);
                String _userType = result.getString(4);

                return new User(_id, _email, _password, _userType);

            }


        } catch (Exception e) {
            System.out.println("Connection failed");
        }

        return null;
    }

    // Getting count of a particular email
    public int getUsersCount(String email) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            mConnection = DriverManager.getConnection(url, username, password);


            if (mConnection == null) {
                System.out.println("Connection not successful");
            }

            System.out.println("Connection is successful");


            String getCountQuery = "SELECT COUNT(*) FROM users WHERE email = '" + email + "' ";

            preparedStatement = mConnection.prepareStatement(getCountQuery);
            preparedStatement.executeQuery();

            ResultSet result = preparedStatement.getResultSet();

            while (result.next()) {
                return result.getInt(1);
            }


        } catch (Exception e) {
            System.out.println("Error occurred while getting count");
        }

        return 0;
    }

    // Getting password for an email
    public String getUsersPassword(String email) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            mConnection = DriverManager.getConnection(url, username, password);


            if (mConnection == null) {
                System.out.println("Connection not successful");
            }

            System.out.println("Connection is successful");


            String getCountQuery = "SELECT password FROM users WHERE email = '" + email + "' ";

            preparedStatement = mConnection.prepareStatement(getCountQuery);
            preparedStatement.executeQuery();

            ResultSet result = preparedStatement.getResultSet();

            while (result.next()) {
                return result.getString(1);
            }


        } catch (Exception e) {
            System.out.println("Error occured while getting count");
        }

        return null;
    }


}
