package com.bridgelabz.EmployeePayrollService;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DataBase {
    public static void main(String a[])
    {
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "Snehal@12345";
        Connection con;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded");
        } catch(ClassNotFoundException e)
        {
            throw new IllegalStateException("Cannot Find Drivers");
        }
        listDrivers();

        try
        {
            System.out.println("Connecting to database"+jdbcUrl);
            con = DriverManager.getConnection(jdbcUrl , userName ,password);
            System.out.println("Connection Successful" +con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void listDrivers()
    {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements())
        {
            Driver driverClass =(Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}
