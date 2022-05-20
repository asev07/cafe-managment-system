package Order;

import EMPLOYEE.Employee;

import java.sql.*;

public class GetOrder {


    public Order[][] hello () throws SQLException
    {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";

        Connection addConn = null;
        Statement statement = null;
        PreparedStatement pS = null;
        Order ord[][] = null;
        try {
            addConn = DriverManager.getConnection(url);
            System.out.println("connected to the data base : " + addConn.getCatalog());
            //getting customer data from getCustomer function
            statement = addConn.createStatement();
            ResultSet rs ;



            String getOrderSize = "select count(*) from s_order ";
            int orderSize = 0 , j=0;

            rs = statement.executeQuery(getOrderSize);
            while (rs.next()) {
                orderSize = rs.getInt(1);
            }

            ord = new Order[orderSize][1];
            for (int i = 0 ; i < orderSize ; i++)
            {
                for(int k = 0 ; k<1 ; k++)
                ord[i][k] = new Order();
            }
                ord[0][0].arrySize= orderSize;
            //String getEmpInfo_query = "select serviceId, id, quantity, employeeid, catagory, singleprice, name, description from s_order,service";
            String getEmpInfo_query = "select * from s_order,service,employee  where s_order.serviceid = service.id and s_order.employeeid = employee.id ";
            rs = statement.executeQuery(getEmpInfo_query);

            while (rs.next()) {

                ord[j][0].serviceId = rs.getInt("serviceId");
                ord[j][0].id = rs.getInt("id");
                ord[j][0].quantity = rs.getInt("quantity");
                ord[j][0].employeeId = rs.getInt("employeeId");
                ord[j][0].catagory = rs.getString("catagory");
                ord[j][0].singlePrice = rs.getDouble("singleprice");
                ord[j][0].name = rs.getString("name");
                ord[j][0].cashierName = rs.getString("firstname");

                j+=1;

            }


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
        return ord;
    }

    public static void main(String[] args) throws SQLException {
        GetOrder o = new GetOrder();
        Order ord [][] =null;
        ord=o.hello();
        for(int i= 0 ; i<ord[0][0].arrySize ; i++)
        System.out.println("\t" + ord[i][0].serviceId + "\t" + ord[i][0].name + "\t" + ord[i][0].catagory + "\t" + ord[i][0].description + "\t" + ord[i][0].arrySize);
    }


}
