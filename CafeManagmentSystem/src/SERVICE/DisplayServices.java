package SERVICE;

import java.sql.*;

public class DisplayServices {
    //display custmers function code starts here
    public void displayAllServices() throws SQLException {


        try {
            System.out.println("Greetings From Intellej IDE !!");
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";

        ResultSet rs = null;
        Connection displayConn = null;
        try {
            displayConn = DriverManager.getConnection(url);
            System.out.println("connected to the data base : " + displayConn.getCatalog());
            String show_all_query = "select * from service";
            Statement statement = displayConn.createStatement();
            rs = statement.executeQuery(show_all_query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String adress = rs.getString("adress");
                int age = rs.getInt("age");
                int salary = rs.getInt("salary");
                System.out.format("%s, %s, %s, %s, %s\n", id, name, adress, age, salary);
                //  displayConn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error in connection to the data base !!!");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("cannot close the connection to the data base:due to the Result set");
                }
            }

            if (displayConn != null) {
                try {
                    displayConn.close();
                } catch (SQLException e) {
                    System.out.println("cannot close the connection to the data base");
                }
            }
        }

        /*
         if(displayConn.isClosed())
         System.out.println("successfully closed the connection");
         else
         System.out.println("connection not closed");
         */
    }
}