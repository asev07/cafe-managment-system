package CodeTester;

import EMPLOYEE.Employee;
import EMPLOYEE.GetEmployeeInfo;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        GetEmployeeInfo g = new GetEmployeeInfo();
        int id = 12345;
        Employee e = new Employee();
        e = g.getEmployeeInfo(id);
        System.out.println(e.age+e.position+e.firstName+e.lastName);
    }
}
