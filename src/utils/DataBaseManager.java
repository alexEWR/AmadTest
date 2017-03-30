package utils;

import tests.RozetkaTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Alex on 30.03.2017.
 * <p>
 * Simple Java program to connect to MySQL database running on localhost and
 * running SELECT and INSERT query to retrieve and add data.
 */
public class DataBaseManager {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/rozetka?autoReconnect=true&useSSL=false";
    private static final String user = "alex";
    private static final String password = "12345";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public DataBaseManager() {
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void getCountOfRows() {
        String query = "select count(*) from smartphones";
        // executing SELECT query
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of smartphones in the table : " + count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllInDataBase() {
        String query = "SELECT id, name, price FROM smartphones";

        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                System.out.printf("id: %d, name: %s, price: %s %n", id, name, author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertInDataBaseSmatrphones(String name, String price, int rudId) {
        String query = "INSERT INTO rozetka.smartphones (name, price, runId) \n" +
                " VALUES ('"+name+"', '"+price+"', '"+rudId+"');";


        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNewRunId(){
        String runQuery = "INSERT INTO rozetka.runs (date) \n" +
                " VALUES ('"+new StringHelper().getCurrentTime()+"');";

        String maxRunId = "SELECT max(idrun) FROM rozetka.runs;";
        try {
            stmt.executeUpdate(runQuery);
            rs = stmt.executeQuery(maxRunId);
            rs.next();
            int runId = rs.getInt(1);
            return runId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//        System.out.println("Finalize executed");
//        try {
//            con.close();
//        } catch (SQLException se) { /*can't do anything */ }
//        try {
//            stmt.close();
//        } catch (SQLException se) { /*can't do anything */ }
//        try {
//            rs.close();
//        } catch (SQLException se) { /*can't do anything */ }
//    }

}
