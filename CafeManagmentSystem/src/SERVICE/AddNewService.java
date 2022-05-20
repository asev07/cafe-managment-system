package SERVICE;
import java.sql.*;

public class AddNewService {
    boolean addNewService(Service c) throws SQLException {
       boolean success = false;
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

            String add_query = "INSERT INTO Employee" + "  ( catagory, singleprice, name, description) VALUES " + " (?, ?, ?, ?);";
        statement = addConn.createStatement();
            pS = addConn.prepareStatement(add_query);
            pS.setString(1, c.catagory);
            pS.setDouble(2, c.singlePrice);
            pS.setString(3, c.name);
            pS.setString(4, c.description);

            pS.executeUpdate();
            System.out.println("Add successfull");
            success = true;
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
