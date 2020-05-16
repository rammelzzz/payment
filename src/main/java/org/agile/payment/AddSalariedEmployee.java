package org.agile.payment;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double salary;

    public AddSalariedEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        this.salary = salary;
    }


    protected PaymentClassification getPaymentClassification() {
        return new SalariedClassification(salary);
    }

    protected PaymentSchedule getPaymentSchedule() {
        return new MonthlyPaymentSchedule();
    }
}
