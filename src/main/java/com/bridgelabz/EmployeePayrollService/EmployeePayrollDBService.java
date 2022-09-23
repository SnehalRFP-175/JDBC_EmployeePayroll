package com.bridgelabz.EmployeePayrollService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
    private Connection getConnection() throws SQLException
    {
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "Snehal@12345";
        Connection con;
        System.out.println("Connecting to Database" +jdbcUrl);
        con = DriverManager.getConnection(jdbcUrl,userName,password);
        System.out.println("Connection Successful....." +con);
        return con;

    }
    public List<EmployeePayroll> readData()
    {
        String sql = " SELECT * FROM employee_payroll; ";

        List<EmployeePayroll> employeePayrollList = new ArrayList<>();
        try
        {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next())
            {
                int id = result.getInt("id");
                String name = result.getString("name");
                double salary = result.getDouble("salary");
                LocalDate startDate = result.getDate("startDate").toLocalDate();
                employeePayrollList.add(new EmployeePayroll(id, name, salary, startDate));
                System.out.println(id+","+name+","+salary+","+startDate);
            }
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String a[])
    {

        EmployeePayrollDBService db = new EmployeePayrollDBService();
        db.readData();
    }
}
