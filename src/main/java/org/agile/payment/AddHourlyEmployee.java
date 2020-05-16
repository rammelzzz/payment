package org.agile.payment;

public class AddHourlyEmployee extends AddEmployeeTransaction {
    private double hourlyRate;


    public AddHourlyEmployee(int empId, String name, String address, double hourlyRate) {
        super(empId, name, address);
        this.hourlyRate = hourlyRate;
    }

    protected PaymentClassification getPaymentClassification() {
        return new HourlyClassification(hourlyRate);
    }

    protected PaymentSchedule getPaymentSchedule() {
        return null;
    }
}
