package EMPLOYEE;

import java.sql.*;

public class GetEmployeeInfo {


        public Employee getEmployeeInfo(int empId) throws SQLException {
            Employee emp = new Employee();
            try {
                DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";

            Connection addConn = null;
            Statement statement ;
            ResultSet rs = null;
            try {
                addConn = DriverManager.getConnection(url);
                System.out.println("connected to the data base : " + addConn.getCatalog());
                //getting customer data from getCustomer function
                System.out.println("ID is " + empId);
                String getEmpInfo_query = "select firstname, lastname, GENDER, age, contrat_type, role_id from employee where id = " + String.valueOf(empId);
                statement = addConn.createStatement();
                rs = statement.executeQuery(getEmpInfo_query);

                while (rs.next()) {

                    emp.firstName = rs.getString("firstName");
                    emp.lastName = rs.getString("lastName");
                    emp.gender = rs.getString("gender");
                    emp.age = rs.getInt("age");
                    emp.contratType = rs.getString("contrat_type");
                    emp.roleId = rs.getInt("role_id");

                }

                System.out.println(getEmpInfo_query);

                String getEmpRoleInfo_query = "select  salary, POSITION from role where id = " + String.valueOf(emp.roleId);

                statement = addConn.createStatement();
                rs = statement.executeQuery(getEmpRoleInfo_query);

                while (rs.next()) {
                    emp.salary = rs.getInt("salary");
                    emp.position = rs.getString("position");

                }




                    emp.id = empId;

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
                assert addConn != null;
                if (addConn.isClosed())
                    System.out.println("successfully closed the connection");
                else
                    System.out.println("connection not closed");

            }
          return emp;
        }




}
