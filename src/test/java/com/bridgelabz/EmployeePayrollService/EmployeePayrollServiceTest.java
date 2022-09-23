package com.bridgelabz.EmployeePayrollService;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollServiceTest {
    @Test
    public void given3EmployeesWhenWrittenToFile_shouldMatchEmployeeEntries(){
        EmployeePayrollFilelOService fileIo = new EmployeePayrollFilelOService();
            List<EmployeePayroll> list = new ArrayList<>();
             list.add(new EmployeePayroll(1,"Snehal",10000));
             list.add(new EmployeePayroll(2,"Pranit",20000));
             list.add(new EmployeePayroll(3,"Prachi",30000));
             list.add(new EmployeePayroll(4,"Puja",35000));

             fileIo.writeDataToFile(list);
             Assertions.assertEquals(4,fileIo.countEntries());
    }

    public void givenEmployeePayrollData_ShouldMatchEmployeeCount()
    {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayroll> employeePayrolls = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(4,employeePayrolls.size());
    }
}
