package com.bridgelabz.EmployeePayrollService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFilelOService {
    public static String PAYROLL_FILE_NAME = "C:\\Users\\dell\\IdeaProjects\\EmployeePayroll\\src\\main\\resources\\PayrollFile.txt";

    public void writeDataToFile(List<EmployeePayroll> employeePayrollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void printData() {
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return entries;
    }

    public void readData() {
        List<EmployeePayroll> list = new ArrayList<>();
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(s -> {
                System.out.println(s);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
