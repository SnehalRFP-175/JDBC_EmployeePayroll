package com.bridgelabz.EmployeePayrollService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static void main(String a[])
    {
        EmployeePayrollDBService db = new EmployeePayrollDBService();
    }
}
