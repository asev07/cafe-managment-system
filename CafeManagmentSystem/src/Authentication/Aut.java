package Authentication;

import EMPLOYEE.Employee;

import java.sql.*;
import java.util.Scanner;

public class Aut {

        public boolean authentication( int id , String password ) throws SQLException {
            boolean success=false;
            try {
                DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";

            Connection addConn = null;
            Statement statement = null;
            ResultSet rs = null;
            try {
                int recordsc = 0;
                addConn = DriverManager.getConnection(url);
                System.out.println("connected to the data base : " + addConn.getCatalog());
                //getting customer data from getCustomer function

                String auth_query = "select count(*) from employee where(id ="+id+" and password='"+password+"')";

                statement = addConn.createStatement();
                rs = statement.executeQuery(auth_query);

                while (rs.next()) {

                     recordsc = rs.getInt(1);
                    //  displayConn.close();
                    System.out.println("records"+ recordsc);
                }

                System.out.println("Authentication process succesfully completed");
                if(recordsc == 1)
                success=true;


            } catch (SQLException e) {
                System.out.println("Error in connection to the data base !!!");
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        System.out.println("cannot close the connection to the data base:due to the result statment");
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
