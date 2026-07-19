package org.example;

public class EmployeeSalaryCalculator {
    static void main() {
        String employeeName = "SALWA ";
        Double basicSalary = 1600.0;
        Double bonusAmount = 800.0;
        Double deductionAmount = 50.0;

        Double netSalary = calculateNetSalary(basicSalary, bonusAmount, deductionAmount);
        String salaryStatus = checkSalaryStatus(netSalary);
        displaySalaryDetails(employeeName, basicSalary, bonusAmount, deductionAmount, netSalary, salaryStatus);
    }

    //Methods
    public static Double calculateNetSalary(Double basicSalary, Double bonusAmount, Double deductionAmount) {
        return basicSalary + bonusAmount - deductionAmount;
    }

    public static String checkSalaryStatus(Double netSalary) {
        if (netSalary < 500) {
            return " Low Salary ";
        } else if (netSalary <= 1500) {
            return " Medium Salary ";
        } else {
            return  "High Salary ";
        }

    }

    public static void displaySalaryDetails(String employeeName, Double  basicSalary, Double bonusAmount,
                                            Double deductionAmount, Double netSalary, String salaryStatus) {
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + bonusAmount);
        System.out.println("Deduction: " + deductionAmount);
        System.out.println("Net Salary: " + netSalary);
        System.out.println("Salary Status: " + salaryStatus);
    }
}
