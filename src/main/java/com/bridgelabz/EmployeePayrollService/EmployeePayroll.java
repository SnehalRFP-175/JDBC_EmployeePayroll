package com.bridgelabz.EmployeePayrollService;

import java.time.LocalDate;

public class EmployeePayroll {
    private int id;
    private String name;
    private double salary;

    private LocalDate startDate;

    //construtor to get values
    public EmployeePayroll(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayroll(int id, String name, double salary, LocalDate startDate)
    {
        this(id, name, salary);
        this.startDate = startDate;
    }


    @Override
    public String toString() {
        return "ID:"+id+
                "\t Name:"+name+
                "\t Salary:"+salary+
                "\t Start Date: "+startDate;
    }
}

