package EMPLOYEE;

import java.sql.*;
import java.util.Scanner;

public class AddNewEmployee {
   Employee getEMployee()
    {
        Scanner s = new Scanner(System.in);
        Employee c = null;
        System.out.println("Enter first name of employee");
        c.firstName = s.nextLine();
        System.out.println("Enter last name of employee");
        c.lastName = s.nextLine();
        System.out.println("Enter age of employee");
        c.age = s.nextInt();
        System.out.println("Enter contract of employee");
        c.contratType = s.nextLine();
        System.out.println("Enter roleId of employee");

        c.roleId = s.nextInt();
        return c;
    }
    boolean addEmployee( Employee c ) throws SQLException {
       boolean success=false;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";

        Connection addConn = null;
        Statement statement = null;
        PreparedStatement pS = null;
        try {

            addConn = DriverManager.getConnection(url);
            System.out.println("connected to the data base : " + addConn.getCatalog());
            //getting customer data from getCustomer function

            String add_query = "INSERT INTO Employee" + "  ( firstname, lastname, age, contratType, roleId) VALUES " + " (?, ?, ?, ?, ?, ?);";

            statement = addConn.createStatement();
            pS = addConn.prepareStatement(add_query);
            pS.setString(1, c.firstName);
            pS.setString(2, c.lastName);
            pS.setInt(3, c.age);
            pS.setString(4, c.contratType);
            pS.setInt(5, c.roleId);
            pS.executeUpdate();
            System.out.println("Add successfull");
            success=false;
            addConn.close();

        } catch (SQLException e) {
            System.out.println("Error in connection to the data base !!!");
            e.printStackTrace();
        } finally {
            if (pS != null) {
                try {
                    pS.close();
                } catch (SQLException e) {
                    System.out.println("cannot close the connection to the data base:due to the prepared statment");
                }
            }

            if (addConn != null) {
                try {
                    addConn.close();
                } catch (SQLException e) {
                    System.out.println("cannot close the connection to the data base");
                }
            }
            if (addConn.isClosed())
                System.out.println("successfully closed the connection");
            else
                System.out.println("connection not closed");

        }
        return success;
    }
}

